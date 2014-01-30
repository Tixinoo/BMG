/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import database.BaseSetting;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author blaise
 */
class PanelConnexion extends JPanel {
    BaseSetting bs;
    
    JTextField[] jtfs = {
        new JTextField(15),
        new JTextField(15)
    };
    JLabel[] labels = {
        new JLabel("Email : "),
        new JLabel("Password : ")
    };
    JLabel labelConnexion = new JLabel(" ... ");

    public PanelConnexion(BaseSetting bs, final MenuPrincipal fen) {
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
        
        this.add(new JLabel("Connexion !!"), BorderLayout.NORTH);
        
        JPanel panCenter = new JPanel();
        for(int i=0;i<2;i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }
        this.add(panCenter, BorderLayout.CENTER);
        
        JPanel panBas = new JPanel();
        panBas.setLayout(new GridLayout(2,1));
        
        JButton buttonConnexion = new JButton("Connexion");
        buttonConnexion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(true) labelConnexion.setText("<html><p style=\"color:green; text-align: center;\">Connexion success !</p></html>");
                else labelConnexion.setText("<html><p style=\"color:green;\">ERREUR !</p></html>");
            }
        });
        
        panBas.add(buttonConnexion);
        panBas.add(labelConnexion);
    }
    
}
