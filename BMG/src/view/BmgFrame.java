/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseSetting;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Bonjour
/**
 * Class BmgFrame
 *
 * @author blaise
 */
public class BmgFrame extends JFrame {

    BaseSetting bs = new BaseSetting();
    int width;
    int height;

    JPanel panSouth = new JPanel();
    static BmgPanel panMain;
    static BmgPanel panSettings;

    /**
     * Constructor who create the main window of BMG.
     *
     * @param string
     */
    public BmgFrame(String string, int width, int height) {
        super(string);
        this.width = width;
        this.height = height;

        setAllPanels();
        setFrameSettings();
    }

    /**
     * This method aims at creating all panels at the beginning.
     */
    private void setAllPanels() {
        panMain = new BmgPanel(new BmgPanelMenu(fen()), BmgCreatePanel.createMainPanel(width, height), new BmgPanelSouth(width));
        panSettings = new BmgPanel(new BmgPanelMenu(fen()), BmgCreatePanel.createPanelSettings(bs, width, height), new BmgPanelSouth(width));
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

    public BmgFrame fen() {
        return this;
    }

    public void setPanel(JPanel pan) {
        
        this.setContentPane(pan);
        this.pack();
    }

}
