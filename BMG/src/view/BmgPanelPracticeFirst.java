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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
                    labelRes.setText("<html><p stype=\"color: blue;\">" + monFichierSplit[monFichierSplit.length-1] + "</p></html>");
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
