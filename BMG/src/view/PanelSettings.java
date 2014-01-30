/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseSetting;
import database.BaseInformation;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Maxime
 */
class PanelSettings extends JPanel {
    BaseSetting bs = new BaseSetting();
    JPanel panCenter = new JPanel();
    JLabel[] labels = {
        new JLabel("Driver (mysql, oracle): "),
        new JLabel("Nom du driver JDBC : "),
        new JLabel("Nom de la base : "),
        new JLabel("Login : "),
        new JLabel("Password : "),
        new JLabel("URL : ")
    };
    JLabel labelConfirm = new JLabel("...");
    JLabel labelTest = new JLabel("...");
    JTextField[] jtfs = {
        new JTextField(25),
        new JTextField(25),
        new JTextField(25),
        new JTextField(25),
        new JTextField(25),
        new JTextField(25)
    };
    JButton buttonConfirm = new JButton("Sauvegarder les informations");
    JButton buttonTest = new JButton("Tester la connexion");
    
    JLabel labelRes = new JLabel("En attente...");
    BaseInformation bi;

    public PanelSettings(BaseInformation bi, final MenuPrincipal fen) {
        super();
        this.bi = bi;
        this.setLayout(new BorderLayout());
        
        setValeurChamp();
        
        panCenter.setLayout(new GridLayout(6, 2));
        for (int i = 0; i < 6; i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }

        JButton btest = new JButton("Retour");
        btest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fen.setPanel(fen.genererPanelPrincipal());
            }
        });
        
        buttonConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new BaseInformation(jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText(), jtfs[5].getText());
                labelConfirm.setText("<html><p style=\"color: green;\">Informations enregistrées</p></html>");
            }
        });
        
        buttonTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bs.miseAJourInfo();
                if (bs.testerConnexion()) {
                    System.out.println("Connexion OK");
                    labelTest.setText("<html><p style=\"color: green;\">Connexion OK</p></html>");
                } else {
                   labelTest.setText("<html><p style=\"color: green;\">ERREUR CONNEXION</p></html>");

                }
            }
        });

        this.setPreferredSize(new Dimension(500,250));
        this.add(btest, BorderLayout.WEST);
        this.add(panCenter, BorderLayout.CENTER);
        
        JPanel panHaut = new JPanel();
        panHaut.setLayout(new GridLayout(2,1));
        panHaut.add(buttonConfirm);
        panHaut.add(labelConfirm);
        this.add(panHaut, BorderLayout.NORTH);
        
        JPanel panSouth = new JPanel();
        panSouth.add(buttonTest);
        panSouth.add(labelTest);
        this.add(panSouth, BorderLayout.SOUTH);
    }
    
    private void setValeurChamp() {
        jtfs[0].setText(bi.getDriver());
        jtfs[1].setText(bi.getNamedriver());
        jtfs[2].setText(bi.getDbname());
        jtfs[3].setText(bi.getLogin());
        jtfs[4].setText(bi.getPassword());
        jtfs[5].setText(bi.getUrl());
    }

}
