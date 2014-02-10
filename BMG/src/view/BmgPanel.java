/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Maxime Blaise
 */
public class BmgPanel extends JPanel {
    JPanel pan = new JPanel();


    /**
     * Constructeur qui se charge de créer la structure d'un panel.
     * @param panMenu
     * @param panCenter
     * @param panSouth 
     */
    public BmgPanel(BmgFrame fen, JPanel pan) {
        //Initialisation du panel et de ses attributs
        super(new BorderLayout());
        
       
        //Ajout des panels au panel principal
        this.add(fen.panMenu, BorderLayout.NORTH);
        this.add(pan, BorderLayout.CENTER);
        this.add(fen.panSouth, BorderLayout.SOUTH);
        repaint();
    }
    
    
}
