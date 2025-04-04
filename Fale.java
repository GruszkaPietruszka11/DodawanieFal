package DodawanieFal;

import javax.swing.JMenu;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Fale extends JFrame implements ActionListener{
    private JMenu menuPlik, menuNarzedzia, menuOpcje, menuPomoc;
    private JMenuBar menuBar;
    private JMenuItem miAutor, mNew, mOtworz, mZapisz, mWyjscie, mOProgramie;

    public Fale(){
        setTitle("Składanie fal");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);

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
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl X")); //skrót klawiszowy do wyjścia z programu

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
        
        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        //menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        
        if (zrodlo == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjść z programu?","Pytanie", JOptionPane.YES_NO_OPTION);
            if(odp == JOptionPane.YES_OPTION) {
                dispose();
            }
        } 
        
        if(zrodlo == mOProgramie) {
            JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0", "Tytuł", JOptionPane.WARNING_MESSAGE);
        }
      
    }
 
}
