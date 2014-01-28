/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Maxime
 */
public class MenuPrincipal extends JFrame {
    
    public MenuPrincipal() {
        super("Maxime BLAISE");
        
        this.setContentPane(this.genererPanelPrincipal());
        
        this.setLocation(300,300);
        this.setPreferredSize(new Dimension(400,400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public JPanel genererPanelPrincipal() {
        JPanel pan = new JPanel();
        
        pan.setLayout(new GridLayout(3,1));
        pan.add(new Button("PRACTICE"));
        pan.add(new Button("GENERATE"));
        
        Button bSettings = new Button("Settings");
        bSettings.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setPanel(new PanelSettings(fen()));
            }
        });
        pan.add(bSettings);
        
        
        return pan;
    }
    
    public MenuPrincipal fen() {
        return this;
    }
    
    public void setPanel(JPanel pan) {
        this.getContentPane().removeAll();
        this.setContentPane(pan);
        this.pack();
    }
}
