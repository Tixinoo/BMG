/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Exercise;

/**
 *
 * @author blaise
 */
public class BmgPanelPracticeFirst extends JPanel {

    String filename = "";
    JLabel labelRes = new JLabel("No file selected.");

    public BmgPanelPracticeFirst(final BmgFrame fen, String name) {
        //Some settings
        this.filename = name;
        int nb = 10;
        String color = "red";

        //Label at first
        JPanel panFirst = new JPanel();
        panFirst.setPreferredSize(new Dimension(fen.width, fen.height / nb));
        final BmgLabel label = new BmgLabel("Ready to become brilliant ? Practice !", color);
        panFirst.add(label);

        //Button choose file
        JButton choosefile = new JButton("Browser..");

        choosefile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                //FileNameExtensionFilter filter = new FileNameExtensionFilter("bmg");
                //jfc.setCurrentDirectory(new File("$HOME/Documents"));
                //jfc.setFileFilter(filter);
                String monFichier = "";
                String approve = "Enregistrer";
                int resultatEnregistrer = jfc.showDialog(jfc, approve);
                if (resultatEnregistrer == JFileChooser.APPROVE_OPTION) {
                    monFichier = jfc.getSelectedFile().toString();
                    if (monFichier.endsWith(".bmg") || monFichier.endsWith(".BMG")) {

                    } else {
                        //monFichier += ".bmg";
                    }
                }
                filename = monFichier;
                if (filename.equals("")) {
                    labelRes.setText("No file selected.");
                } else {
                    String[] monFichierSplit = monFichier.split("/");
                    String trueFileName = monFichierSplit[monFichierSplit.length-1];
                    
                    //Exercise exercise = new Exercise();
                    
                    FileReader file;
                    try {
                        file = new FileReader(filename);
                        BufferedReader br = new BufferedReader(file);
                        
                        System.out.println(br.toString());
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BmgPanelPracticeFirst.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println(filename);
                    
                    Exercise exercise = Exercise.load(filename);
                    
                    if(exercise == null) {
                        System.out.println("EXERCISE NULL");
                    }
                    //Label with summary
                    labelRes.setText("<html><p stype=\"color: blue;\">Résumé de : " + trueFileName + "</p>"
                            + "<p>Title : " + exercise.getTitle() + "</p>"
                            + "<p>Type : " +exercise.getType()+ "</p>" 
                            + "<p>Difficulty : "+exercise.getDifficulty()+"</p>"
                            + "<p>Number of questions : "+exercise.getNumberOfQuestions()+"</p>"
                            + "<p>siogheruhgurehgerhgtuohioh</p>"
                            + "</html>");
                }

            }
        });

        this.add(panFirst);
        
        JPanel panChoose = new JPanel();
        panChoose.setPreferredSize(new Dimension(fen.width, fen.height / nb));
        panChoose.add(choosefile);
        this.add(panChoose);

        JPanel panSouth = new JPanel();
        panSouth.setPreferredSize(new Dimension(fen.width, fen.height / nb));

        panSouth.add(labelRes);

        this.add(panSouth);

    }

    public void addSomething(Component c) {
        this.add(c);
    }

}
