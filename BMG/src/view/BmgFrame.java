/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

// Here all imports needed for this class.
import database.BaseSetting;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Bonjour
/**
 * Class BmgFrame
 *
 * @author Maxime Blaise
 */
public final class BmgFrame extends JFrame {
    //Needed fields.
    BaseSetting bs = new BaseSetting();
    int width;
    int height;

    //Menu bar and label in south, generate only once.
    BmgPanelMenu panMenu;
    BmgPanelSouth panSouth;

    //Main pan!!
    BmgPanel pan;

    // All panel needed for our program.
    static JPanel panMain;
    static JPanel panSettings;
    static JPanel panSignup;
    static JPanel panSignin;
    static JPanel panAboutUs;

    /**
     * Constructor who create the main window of BMG.
     *
     * @param string
     * @param width
     * @param height
     */
    public BmgFrame(String string, int width, int height) {
        super(string);
        this.width = width;
        this.height = height;

        //Create these panel.
        panMenu = new BmgPanelMenu(fen());
        panSouth = new BmgPanelSouth(width);

        //Create all panels for our program, once at beginning only !
        setAllPanels();
        
        //Frame settings
        setFrameSettings();
    }

    /**
     * This method aims at creating all panels at the beginning.
     * 
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
        
        //All settings
        this.setPanel(panMain);
        this.setLocation(200, 100);
        this.setPreferredSize(new Dimension(width, height));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pack();
        this.setVisible(true);
        
        //Begin frame, just once !
        BmgFrameBegin bmgFrameBegin = new BmgFrameBegin(bs, fen());
    }

    /**
     * Return this frame.
     * @return 
     */
    public BmgFrame fen() {
        return this;
    }

    /**
     * Change only the center panel !
     * @param panel 
     */
    public void setPanel(JPanel panel) {

        this.setContentPane(new BmgPanel(fen(), panel));
        this.pack();
    }

}
