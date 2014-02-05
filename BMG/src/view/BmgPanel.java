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

    private JPanel panMenu;
    private JPanel panCenter;
    private JPanel panSouth;

    /**
     * Constructeur qui se charge de créer la structure d'un panel.
     * @param panMenu
     * @param panCenter
     * @param panSouth 
     */
    public BmgPanel(JPanel panMenu, JPanel panCenter, JPanel panSouth) {
        //Initialisation du panel et de ses attributs
        super(new BorderLayout());
        this.panMenu = panMenu;
        this.panCenter = panCenter;
        this.panSouth = panSouth;

        //Ajout des panels au panel principal
        this.add(this.panMenu, BorderLayout.NORTH);
        this.add(this.panCenter, BorderLayout.CENTER);
        this.add(this.panSouth, BorderLayout.SOUTH);
    }

}
