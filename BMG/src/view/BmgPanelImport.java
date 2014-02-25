/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author blaise
 */
public class BmgPanelImport extends JPanel {
    
    public BmgFrame fen;
    public JPanel panHaut;

    /**
     * Création du panel qui permet d'importer un exercice.
     * 
     * @param fen 
     */
    BmgPanelImport(BmgFrame fen) {
        super();
        
        this.fen = fen;
        
        this.setLayout(new BorderLayout());
        
        this.setPanelHaut();
    }

    private void setPanelHaut() {
        panHaut = new JPanel();
        
        
        this.add(panHaut, BorderLayout.NORTH);
    }
    
}
