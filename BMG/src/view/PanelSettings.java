/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Maxime
 */
class PanelSettings extends JPanel {

    public PanelSettings(final MenuPrincipal fen) {
        super();
        this.add(new JLabel("Test"));
        
        JButton btest = new JButton("Retour");
        btest.addActionListener(new ActionListener() {

           
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bonjour");
               //fen.setPanel(fen.genererPanelPrincipal());
            }
        });
 
        this.add(btest);
   
    }
    
}
