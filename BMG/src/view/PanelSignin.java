/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseSetting;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import user.User;

/**
 *
 * @author blaise
 */
public class PanelSignin extends JPanel {

    BaseSetting bs;
    JTextField[] jtfs = {
        new JTextField(15),
        new JTextField(15),
        new JTextField(15),
        new JTextField(15),
        new JTextField(15)
    };
    
    JLabel[] labels = {
        new JLabel("First name"),
        new JLabel("Last name"),
        new JLabel("School"),
        new JLabel("Email"),
        new JLabel("Password")
    };
    JLabel labelRes = new JLabel(" ...");
    
    public PanelSignin(final BaseSetting bs, final MenuPrincipal fen) {
        super();
        this.bs = bs;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,250));
        JButton bReturn = new JButton("Retour");
        bReturn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fen.setPanel(fen.genererPanelPrincipal());
            }
        });

        this.add(bReturn, BorderLayout.WEST);
        
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(5,2));
        for(int i=0;i<5;i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }
        
        this.add(new JLabel("Enregistrement d'un utilisateur : "), BorderLayout.NORTH);
        this.add(panCenter, BorderLayout.CENTER);

        JButton buttonSignin = new JButton("Sign in");
        buttonSignin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(User.signIn(bs, 1, jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText()))
                    labelRes.setText("<html><p style=\"color:green; text-align: center;\">Sign in success !</p></html>");
                else 
                    labelRes.setText("<html><p style=\"color:green;\">ERREUR !</p></html>");
            }
        });
        JPanel panBas = new JPanel();
        panBas.setLayout(new GridLayout(2,1));
        panBas.add(buttonSignin);
        panBas.add(labelRes);
        
        this.add(panBas, BorderLayout.SOUTH);
        
    }

}
