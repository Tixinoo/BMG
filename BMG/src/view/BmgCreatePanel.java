/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseInformation;
import database.BaseSetting;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleRole;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author blaise
 */
public class BmgCreatePanel {

    public BmgCreatePanel() {
    }

    /**
     * This method create the main panel.
     *
     * @param width
     * @param height
     * @return
     */
    public static JPanel createMainPanel(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        int nb = 5;
        String colortitle = "green";
        String colortext = "black";
        JPanel pan = new JPanel();

        //Panel Exercises
        JPanel panExercises = new JPanel();
        panExercises.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panExercises.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Training with exercises !</p></html>"));
        panExercises.setLayout(new GridLayout(2, 2));
        panExercises.add(new BmgLabel("Automatically generate exercises : ", colortext));
        BmgButton bgenerate = new BmgButton("Generate");
        panExercises.add(bgenerate);
        panExercises.add(new BmgLabel("Let's practice here : ", colortext));
        BmgButton bpractice = new BmgButton("Practice");
        panExercises.add(bpractice);

        //Panel Account
        JPanel panAccount = new JPanel();
        panAccount.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panAccount.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Account setting !</p></html>"));
        panAccount.setLayout(new GridLayout(2, 2));
        panAccount.add(new BmgLabel("Sign in here : ", colortext));
        BmgButton bsignin = new BmgButton("Sign in");
        panAccount.add(bsignin);
        panAccount.add(new BmgLabel("You should create an account if you don't have ", colortext));
        BmgButton bsignup = new BmgButton("Sign up now !");
        bsignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignup);
            }
        });
        panAccount.add(bsignup);

        //Panel Database Settings
        JPanel panSettings = new JPanel();
        panSettings.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panSettings.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Database setting !</p></html>"));
        panSettings.setLayout(new GridLayout(2, 2));
        panSettings.add(new BmgLabel("Change database settings : ", colortext));
        BmgButton bsettings = new BmgButton("Settings");
        bsettings.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSettings);
            }
        });
        panSettings.add(bsettings);
        panSettings.add(new BmgLabel("Test your database connexion : ", colortext));
        BmgButton btest = new BmgButton("-->Test");
        panSettings.add(btest);

        pan.add(panExercises);
        pan.add(panAccount);
        pan.add(panSettings);
        return pan;
    }
    
    public static JPanel createPanelSignin(BmgFrame fen, final BaseSetting bs, int width, int height) {
        JPanel pan = new JPanel();
        int nb = 4;

        BmgLabel label = new BmgLabel("You have an account ? Sign in now ", "red");
        label.setPreferredSize(new Dimension(width-100, (height - 100) / (2*nb)));
        pan.add(label, BorderLayout.NORTH);

        JPanel panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(2, 2));
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));
        JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),
            
        };
        JLabel[] labels = {
            new JLabel("Email address : "),
            new JLabel("Password : "),
            
        };
        
        for(int i=0;i<labels.length;i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }
        
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new BorderLayout());
        
        BmgButton buttonSignin = new BmgButton("Sign in now !");
        buttonSignin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Sign in success (or not) !", "Sign up information", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
        
        panSouth.add(buttonSignin, BorderLayout.NORTH);
       
        pan.add(panCenter, BorderLayout.CENTER);
        pan.add(panSouth, BorderLayout.SOUTH);

        return pan;
    }

    public static JPanel createPanelSignup(BmgFrame fen, final BaseSetting bs, int width, int height) {
        JPanel pan = new JPanel();
        int nb = 2;

        BmgLabel label = new BmgLabel("Sign up now, for free of course : ", "red");
        label.setPreferredSize(new Dimension(width-100, (height - 100) / (2*nb)));
        pan.add(label, BorderLayout.NORTH);

        JPanel panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(6, 2));
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));
        JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15)
        };
        JLabel[] labels = {
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel("")
        };
        
        for(int i=0;i<labels.length;i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }
        
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new BorderLayout());
        
        BmgButton buttonSignup = new BmgButton("Sign up now !");
        buttonSignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Sign up success (or not) !", "Sign up information", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
        
        panSouth.add(buttonSignup, BorderLayout.NORTH);
       
        pan.add(panCenter, BorderLayout.CENTER);
        pan.add(panSouth, BorderLayout.SOUTH);

        return pan;
    }

    public static JPanel createPanelSettings(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        int nb = 2;
        JPanel pan = new JPanel();
        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(width - 100, (height - 100) / (nb * 2)));
        JPanel panCenter = new JPanel();
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));

        final JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15)
        };
        JLabel[] labels = {
            new JLabel("Pilote : "),
            new JLabel("Driver : "),
            new JLabel("Database name : "),
            new JLabel("Login : "),
            new JLabel("Password : "),
            new JLabel("Url : ")
        };

        panCenter.setLayout(new GridLayout(6, 2));
        for (int i = 0; i < jtfs.length; i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }

        JButton buttonConfirm = new JButton("Register information");
        final BmgLabel labelRes = new BmgLabel("Waiting ...", "green");
        buttonConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new BaseInformation(jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText(), jtfs[5].getText());
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Registration success !", "Database Connexion", JOptionPane.INFORMATION_MESSAGE);
                bs.setInfo();
            }
        });
        JButton buttonTest = new JButton("Connexion test");
        final BmgLabel labelTest = new BmgLabel("Waiting ...", "red");
        buttonTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new BaseInformation(jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText(), jtfs[5].getText());

                bs.setInfo();

                JOptionPane jop = new JOptionPane();
                if (bs.testerConnexion()) {
                    jop.showMessageDialog(null, "Success !", "Database Connexion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    jop.showMessageDialog(null, "Error !", "Database Connexion", JOptionPane.ERROR_MESSAGE);

                }

                /*if(bs.testerConnexion()) {
                 labelTest.set("Success !!");
                 } else {
                 labelTest.set("Error !!");
                 }*/
            }
        });

        jtfs[0].setText(bs.getBi().getDriver());
        jtfs[1].setText(bs.getBi().getNamedriver());
        jtfs[2].setText(bs.getBi().getDbname());
        jtfs[3].setText(bs.getBi().getLogin());
        jtfs[4].setText(bs.getBi().getPassword());
        jtfs[5].setText(bs.getBi().getUrl());

        pan.add(label, BorderLayout.NORTH);
        pan.add(panCenter, BorderLayout.CENTER);

        JPanel panSouth = new JPanel();
        panSouth.add(buttonConfirm);
        panSouth.add(buttonTest);
        pan.add(panSouth, BorderLayout.SOUTH);
        return pan;
    }

    /* public static JPanel createMainPanel2(int width, int height) {
     JPanel panPrincipal = new JPanel();
     panPrincipal.setLayout(new BorderLayout());

     JPanel pan = new JPanel();

     pan.setLayout(new GridLayout(5, 1));
     pan.add(new Button("PRACTICE"));
     pan.add(new Button("GENERATE"));

     Button bSettings = new Button("Settings");
     bSettings.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {

     //setPanel(new PanelSettings(bs.getBaseInformations(), fen()));
     }
     });
     Button bSignin = new Button("Sign in");
     bSignin.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
     // setPanel(new PanelSignin(bs, fen()));
     }
     });
     Button bConnexion = new Button("Connexion");
     bConnexion.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
     // setPanel(new PanelConnexion(bs, fen()));
     }
     });
     pan.add(bSettings);
     pan.add(bSignin);
     pan.add(bConnexion);

     JPanel panHaut = new JPanel();
     //panHaut.setLayout(new GridLayout(2,1));
     panHaut.setLayout(new BoxLayout(panHaut, BoxLayout.PAGE_AXIS));

     panPrincipal.add(panHaut, BorderLayout.NORTH);
     panPrincipal.add(pan, BorderLayout.CENTER);
     return panPrincipal;
     }*/
}
