/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

// Here all imports needed for this class.
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxime Blaise
 */
public class BmgMenuBar extends JMenuBar {

    JButton buttonIndex = new JButton(new ImageIcon("index_small.png"));
    JMenu menuExercises = new JMenu("Exercises");
    JMenuItem itemGenerate = new JMenuItem("Generate");
    JMenuItem itemPractice = new JMenuItem("Practice");

    JMenu menuAccount = new JMenu("Account");
    JMenuItem itemSignIn = new JMenuItem("Sign in");
    JMenuItem itemSignUp = new JMenuItem("Sign up now !");

    JMenu menuSettings = new JMenu("Settings");
    JMenuItem itemBaseSettings = new JMenuItem("Base Settings");
    JMenuItem itemConnexionTest = new JMenuItem("Connexion Test");

    JMenu menuHelp = new JMenu("?");
    JMenuItem itemHelp = new JMenuItem("Help");
    JMenuItem itemAbout = new JMenuItem("About us");

    BmgFrame fen;
    String s = "Not connected yet";

    /**
     * Create BmgMenuBar
     *
     * @param fen
     */
    public BmgMenuBar(BmgFrame fen) {
        super();
        this.fen = fen;

        buttonIndex.setMaximumSize(new Dimension(40, 40));

        setMenuSettings(fen.width);
    }

    private void setMenuSettings(int width) {
        this.setPreferredSize(new Dimension(width, 40));

        setIndexSettings();
        
        setMenuExercisesSettings();

        setMenuAccountSettings();

        setMenuBaseSettings();

        setMenuHelpSettings();

        //Others settings
        String slabel = "<html><p style=\"margin-left: 250px;\">" + this.s + "</p></html>";
        JLabel labelConnexion = new JLabel(slabel);
        this.add(labelConnexion);
    }
    
    /**
     * Exercises menu.
     */
    private void setMenuExercisesSettings() {
        menuExercises.add(itemGenerate);
        menuExercises.add(itemPractice);
        this.add(menuExercises);
    }

    /**
     * Help menu.
     */
    private void setMenuHelpSettings() {
        menuHelp.add(itemHelp);
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                fen.setPanel(BmgFrame.panAboutUs);
            }
        });
        menuHelp.add(itemAbout);
        this.add(menuHelp);
    }

    /**
     * Menu base settings, with information of database and test connection.
     */
    private void setMenuBaseSettings() {
        itemBaseSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                fen.setPanel(BmgFrame.panSettings);
            }
        });
        menuSettings.add(itemBaseSettings);
        itemConnexionTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane jop = new JOptionPane();
                fen.bs.setInfo();
                if (fen.bs.testerConnexion()) {
                    JOptionPane.showMessageDialog(null, "Success !", "Database Connexion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error !", "Database Connexion", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        menuSettings.add(itemConnexionTest);

        this.add(menuSettings);
    }

    /**
     * Set settings for account menu, with sign in and sign up.
     */
    private void setMenuAccountSettings() {
        itemSignIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignin);
            }
        });
        menuAccount.add(itemSignIn);
        itemSignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignup);
            }
        });
        menuAccount.add(itemSignUp);
        this.add(menuAccount);
    }

    /**
     * Set settings for index button.
     */
    private void setIndexSettings() {
        buttonIndex.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panMain);
            }
        });
        this.add(buttonIndex);
    }
}
