package addingWaves;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;


public class Waves extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
	private JMenu menuFile, menuHelp;
    private JMenuBar menuBar;
    private JMenuItem mNew, mOpen, mSave, mSaveWav, mExit, mAbout;

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
        mOpen.addActionListener(this);

        menuBar = new JMenuBar();
        mNew = new JMenu("New");
        mNew.addActionListener(this);

        mSave = new JMenuItem("Save");
        mSave.addActionListener(this);

        mSaveWav = new JMenuItem("Save to *wav");
        mSaveWav.addActionListener(this);
        
        mExit = new JMenuItem("Exit");
        mExit.addActionListener(this);
        mExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuFile.add(mOpen);
        menuFile.addSeparator();
        menuFile.add(mNew);
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
        //menuBar.add(menuTools);
        menuBar.add(menuHelp);
        SettingsPanel settings1Panel = new SettingsPanel();
        settings1Panel.setMinimumSize(new Dimension(300,300));
        this.add(new GraphPanel(), "w 50:2000, h 100:500");
        this.add(new GraphPanel(), "w 50:2000, h 100:500");
        this.add(new GraphPanel(),"wrap, w 50:2000, h 100:500");
        this.add(new SettingsPanel(), "w 250:300");
        this.add(new SettingsPanel(), "w 250:300");
        this.add(new ResultSettingsPanel(), "w 250:300");
        
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        
        if (zrodlo == mExit) {
            int odp = JOptionPane.showConfirmDialog(null, "Are you sure?","Exiting the program", JOptionPane.YES_NO_OPTION);
            if(odp == JOptionPane.YES_OPTION) {
                dispose();
            }
            
        } 
        
        if(zrodlo == mAbout) {
            JOptionPane.showMessageDialog(null, "The program demonstrates adding of sound waves.", "About", JOptionPane.WARNING_MESSAGE);
        }
      
    }
 
}
