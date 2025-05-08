package addingWaves;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import net.miginfocom.swing.MigLayout;


public class Waves extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
	private JMenu menuFile, menuHelp;
    private JMenuBar menuBar;
    private JMenuItem mOpen, mSave, mSaveWav, mExit, mAbout;
    private SettingsPanel[] panels;
    private ResultSettingsPanel resultPanel;

    public Waves(){
        setTitle("Adding waves");
        setSize(1300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new MigLayout("flowy"));
        initializeGUI();
    }
    void initializeGUI() {
    	menuBar = new JMenuBar();
        menuFile = new JMenu("File");

        mOpen = new JMenuItem("Open");
        mOpen.addActionListener(e->open());
        mOpen.addActionListener(this);

        menuBar = new JMenuBar();

        mSave = new JMenuItem("Save");
        mSave.addActionListener(e->save());
        mSave.addActionListener(this);

        mSaveWav = new JMenuItem("Save to *wav");
        mSaveWav.addActionListener(this);
        
        mExit = new JMenuItem("Exit");
        mExit.addActionListener(this);
        //mExit.setAccelerator(KeyStroke.getKeyStroke("Ctrl + x"));

        menuFile.add(mOpen);
        menuFile.addSeparator();
        menuFile.add(mSave);
        menuFile.addSeparator();
        menuFile.add(mSaveWav);
        menuFile.addSeparator();
        menuFile.add(mExit);

        menuHelp = new JMenu("Help");
        mAbout = new JMenuItem("About program");
        menuHelp.add(mAbout);
        mAbout.addActionListener(this);
        
        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        SettingsPanel settings1Panel = new SettingsPanel();
        settings1Panel.setMinimumSize(new Dimension(300,300));
        panels = new SettingsPanel[2];
        panels[0]=new SettingsPanel();
        panels[1]=new SettingsPanel();
        resultPanel = new ResultSettingsPanel();
    	panels[0].getPanel().setChart(panels[0].getPanel().makeChart(panels[0].getPanel().calculateSeries()));
        panels[1].getPanel().setChart(panels[1].getPanel().makeChart(panels[1].getPanel().calculateSeries()));
        this.add(panels[0].getPanel(), "w 50:2000, h 100:500");
        this.add(panels[1].getPanel(), "w 50:2000, h 100:500");
        this.add(resultPanel.getPanel(),"wrap, w 50:2000, h 100:500");
        this.add(panels[0], "w 250:300");
        this.add(panels[1], "w 250:300");
        this.add(resultPanel, "w 250:300");
        mergeCharts();
        }
    
    private void mergeCharts() {
    	XYSeriesCollection dataset = new XYSeriesCollection();
    	dataset.addSeries(addSeries());
    	for (SettingsPanel p : panels) {
    		try {
				dataset.addSeries(p.getPanel().getDataset().getSeries(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
		resultPanel.getPanel().setChart(resultPanel.getPanel().makeChart(dataset));
		resultPanel.getPanel().getChart().getXYPlot().getRenderer().setSeriesPaint(1,panels[0].getPanel().getStroke());
		resultPanel.getPanel().getChart().getXYPlot().getRenderer().setSeriesPaint(2,panels[1].getPanel().getStroke());
		resultPanel.getPanel().getChart().getXYPlot().getRenderer().setSeriesVisible(1,false);
		resultPanel.getPanel().getChart().getXYPlot().getRenderer().setSeriesVisible(2,false);
    }
    
    private XYSeries addSeries() {
    	XYSeries series = new XYSeries(""+Math.random());
    	double freq=Math.min(panels[0].getPanel().getFrequency(), panels[1].getPanel().getFrequency());
    	for (int ii=0; ii<GraphPanel.getNOP()+1; ii++) {
			double t=ii*3/freq/GraphPanel.getNOP();
			double x = 0;
			for (SettingsPanel p : panels) {
				x+=p.getPanel().getAmplitude()*Math.sin(2*Math.PI*p.getPanel().getFrequency()*t+p.getPanel().getPhase());
			}
			series.add(t, x);
		}
    	return series;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == mExit) {
            int ans = JOptionPane.showConfirmDialog(null, "Are you sure?","Exiting the program", JOptionPane.YES_NO_OPTION);
            if(ans == JOptionPane.YES_OPTION) {
                dispose();
            }
        } 
        
        if(source == mAbout) {
            JOptionPane.showMessageDialog(null, "The program demonstrates adding of sound waves.", "About", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void save() {
    	File outputFile;
    	JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            outputFile = fileChooser.getSelectedFile();
            try {
				PrintWriter writer = new PrintWriter(outputFile);
				writer.print(panels[0].getData()+"\n"+panels[1].getData());
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        }
    }
    
    public void open() {
    	File inputFile;
    	JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
            try {
				Scanner scan = new Scanner(inputFile);
				for (SettingsPanel p : panels) {
					p.getPanel().setAmplitude(Double.valueOf(scan.next()));
					p.getPanel().setFrequency(Double.valueOf(scan.next()));
					p.getPanel().setPhase(Double.valueOf(scan.next()));
					p.getPanel().setChart(p.getPanel().makeChart(p.getPanel().calculateSeries()));
					p.updateBoxes();
				}
				scan.close();
				mergeCharts();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        }
    }
 
}
