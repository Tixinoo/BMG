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

    BmgPanelMenu panMenu;
    BmgPanelSouth panSouth;

    BmgPanel pan;

    static JPanel panMain;
    static JPanel panSettings;
    static JPanel panSignup;
    static JPanel panSignin;
    static JPanel panAboutUs;

    /**
     * Constructor who create the main window of BMG.
     *
     * @param string
     */
    public BmgFrame(String string, int width, int height) {
        super(string);
        this.width = width;
        this.height = height;

        panMenu = new BmgPanelMenu(fen());
        panSouth = new BmgPanelSouth(width);

        setAllPanels();
        setFrameSettings();
    }

    /**
     * This method aims at creating all panels at the beginning.
     */
    private void setAllPanels() {
        panMain = BmgCreatePanel.createMainPanel(fen(), bs, width, height);
        panSettings = BmgCreatePanel.createPanelSettings(fen(), bs, width, height);
        panSignin = BmgCreatePanel.createPanelSignin(fen(), bs, width, height);
        panSignup = BmgCreatePanel.createPanelSignup(fen(), bs, width, height);
        panAboutUs = BmgCreatePanel.createPanelAboutUs(fen(), bs, width, height);
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
        new BmgFrameBegin(bs, fen());
    }

    public BmgFrame fen() {
        return this;
    }

    public void setPanel(JPanel panel) {

        this.setContentPane(new BmgPanel(fen(), panel));
        this.pack();
    }

}
