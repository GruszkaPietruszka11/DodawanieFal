package DodawanieFal;

import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Fale extends JFrame implements ActionListener{
    private JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    private JMenuBar menuBar;
    private JMenuItem miAutor, mNew, mOtworz, mZapisz, mWyjscie, mOProgramie;
    private JTextArea notatnik;//narazie jest jako notatnik ale tu ma być wykres

    public Fale(){
        setTitle("Składanie fal");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());
        initializeGUI();
    }
    void initializeGUI() {
    	menuBar = new JMenuBar();
        menuPlik = new JMenu("File");

        mOtworz = new JMenuItem("Open");
        mOtworz.addActionListener(this);

        menuBar = new JMenuBar();
        mNew = new JMenu("New");
        mNew.addActionListener(this);

        mZapisz = new JMenuItem("Save");
        mZapisz.addActionListener(this);

        mWyjscie = new JMenuItem("Exit");
        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuPlik.add(mOtworz);
        menuPlik.addSeparator();
        menuPlik.add(mNew);
        menuPlik.addSeparator();
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mWyjscie);

        menuPomoc = new JMenu("Help");
        mOProgramie = new JMenuItem("About program");
        menuPomoc.add(mOProgramie);
        mOProgramie.addActionListener(this);
        
        setJMenuBar(menuBar);//to samo co add ale do dodania menuBar
        menuBar.add(menuPlik);
        //menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);
        
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
        
        if (zrodlo == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjść z programu?","Pytanie", JOptionPane.YES_NO_OPTION);
            if(odp == JOptionPane.YES_OPTION) {
                dispose();
            } else if(odp == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Wiedziałam");
            } else if(odp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Tak nie robimy","Tytuł",JOptionPane.WARNING_MESSAGE);
            }
            
        } 
        
        if(zrodlo == mOProgramie) {
            JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0", "Tytuł", JOptionPane.WARNING_MESSAGE);
        }
      
    }
 
}
