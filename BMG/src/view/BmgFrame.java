/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class BmgFrame
 * @author blaise
 */
public class BmgFrame extends JFrame {
    int width;
    int height;
    
    BmgMenuBar menu;
    JPanel panMenu = new JPanel();
    JPanel panSouth = new JPanel();
    BmgPanel panMain;

    /**
     * Constructor who create the main window of BMG.
     * @param string 
     */
    public BmgFrame(String string, int width, int height) {
        super(string);
        this.width = width;
        this.height= height;
        
        //Settings north and south panel
        menu = new BmgMenuBar(width);
        panMenu.add(menu);
        panSouth.add(new BmgLabel("©M.Blaise, A.Nosal, J.Rische, J.Dzimbalka, for BMG 2013/2014", "green"));

        setAllPanels();
        setFrameSettings();
    }
    
    /**
     * This method aims at creating all panels at the beginning.
     */
    private void setAllPanels() {
        panMain = new BmgPanel(panMenu, BmgCreatePanel.createMainPanel(width, height), panSouth);
    }

    /**
     * Method who change window's settings.
     */
    private void setFrameSettings() {
        this.setPanel(panMain);
        this.setLocation(200, 100);
        this.setPreferredSize(new Dimension(width, height));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    
    public void setPanel(JPanel pan) {
        this.getContentPane().removeAll();
        this.pack();
        this.setContentPane(pan);
        this.pack();
    }

}
