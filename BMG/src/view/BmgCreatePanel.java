/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author blaise
 */
public class BmgCreatePanel {

    public BmgCreatePanel() {
    }

    public static JPanel createMainPanel(int width, int height) {
        int nb = 4;
        String colortitle = "red";
        String colortext = "black";
        JPanel pan = new JPanel();

        JPanel panExercises = new JPanel();
        panExercises.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panExercises.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: "+colortitle+";\">Training with exercises !</p></html>"));
        panExercises.setLayout(new GridLayout(2,2));
        panExercises.add(new BmgLabel("Automatically generate exercises : ", colortext));
        BmgButton bgenerate = new BmgButton("Generate");
        panExercises.add(bgenerate);
        panExercises.add(new BmgLabel("Let's practice here : ", colortext));
        BmgButton bpractice = new BmgButton("Practice");
        panExercises.add(bpractice);
        
        JPanel panAccount = new JPanel();
        panAccount.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panAccount.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: "+colortitle+";\">Database setting !</p></html>"));
        panAccount.setLayout(new GridLayout(2,2));
        panAccount.add(new BmgLabel("Sign in here : ", colortext));
        BmgButton bsignin = new BmgButton("Sign in");
        panAccount.add(bsignin);
        panAccount.add(new BmgLabel("You should create an account if you don't have ", colortext));
        BmgButton bsignup = new BmgButton("Sign up now !");
        panAccount.add(bsignup);
        
        JPanel panSettings = new JPanel();
        panSettings.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panSettings.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: red;\">Database setting !</p></html>"));
        panSettings.setLayout(new GridLayout(2,2));
        panSettings.add(new BmgLabel("Change database settings : ", colortext));
        BmgButton bsettings = new BmgButton("Settings");
        panSettings.add(bsettings);
        panSettings.add(new BmgLabel("Test your database connexion : ", colortext));
        BmgButton btest = new BmgButton("-->Test");
        panSettings.add(btest);
        
        pan.add(panExercises);
        pan.add(panAccount);
        pan.add(panSettings);
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
