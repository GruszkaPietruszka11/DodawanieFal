package DodawanieFal;

import javax.swing.JMenu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


import javax.swing.*;


public class Fale extends JFrame implements ActionListener{
    private JMenu menuFile, menuTools, menuOptions, menuHelp;
    private JMenuBar menuBar;
    private JMenuItem miAutor, mNew, mOpen, mSave, mSaveWav, mExit, mAbout;

    public Fale(){
        setTitle("Adding waves");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());
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
        
        setJMenuBar(menuBar);//to samo co add ale do dodania menuBar
        menuBar.add(menuFile);
        //menuBar.add(menuTools);
        menuBar.add(menuHelp);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        this.add(panel,BorderLayout.EAST);
        SettingsPanel spanel = new SettingsPanel();
        panel.add(spanel);
        SettingsPanel spanel2 = new SettingsPanel();
        panel.add(spanel2);
        FinalPanel fpanel = new FinalPanel();
        panel.add(fpanel);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1, 10, 10));
        this.add(panel2,BorderLayout.CENTER);
        GraphPanel gpanel = new GraphPanel();
        panel2.add(gpanel);
        GraphPanel gpanel2 = new GraphPanel();
        panel2.add(gpanel2);
        GraphPanel gpanel3 = new GraphPanel();
        panel2.add(gpanel3);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        
        if (zrodlo == mExit) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjść z programu?","Pytanie", JOptionPane.YES_NO_OPTION);
            if(odp == JOptionPane.YES_OPTION) {
                dispose();
            }
            
        } 
        
        if(zrodlo == mAbout) {
            JOptionPane.showMessageDialog(null, "Program demonstruje składanie fal dźwiękowych", "O programie", JOptionPane.WARNING_MESSAGE);
        }
      
    }
 
}


//nazwy + tekst po angielsku
//lepsze nazwy ogólnie
//miglayout do okna
//skrót (ewentualnie)
