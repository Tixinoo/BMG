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
    JMenuItem itemSolve = new JMenuItem("Solve");
    JMenuItem itemImport = new JMenuItem("Import");
    JMenuItem itemExport = new JMenuItem("Export");
    JMenuItem itemEdit = new JMenuItem("Edit");

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
        //Add listener and add items.
        addListenersMenuExercises();
        addItemMenuExercises();
    }

    /**
     * Add listeners in all items in menu exercises.
     */
    private void addListenersMenuExercises() {

    }

    /**
     * Add all items into menu.
     */
    private void addItemMenuExercises() {
        menuExercises.add(itemGenerate);
        menuExercises.add(itemPractice);
        menuExercises.add(itemSolve);
        menuExercises.add(itemImport);
        menuExercises.add(itemExport);
        menuExercises.add(itemEdit);
        this.add(menuExercises);
    }

    /**
     * Help menu.
     */
    private void setMenuHelpSettings() {
        //Add listener and add items.
        addListenersMenuHelp();
        addItemMenuHelp();
    }

    /**
     * Add listeners in all items in help menu.
     */
    private void addListenersMenuHelp() {
        // About Us !
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                fen.setPanel(BmgFrame.panAboutUs);
            }
        });
    }

    /**
     * Add items into help menu.
     */
    private void addItemMenuHelp() {
        menuHelp.add(itemHelp);
        menuHelp.add(itemAbout);
        this.add(menuHelp);
    }

    /**
     * Menu base settings, with information of database and test connection.
     */
    private void setMenuBaseSettings() {
        addListenersBaseMenu();
        addItemBaseMenu();
    }

    /**
     * Add listeners in all items in base menu.
     */
    private void addListenersBaseMenu() {
        // Database settings
        itemBaseSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                fen.setPanel(BmgFrame.panSettings);
            }
        });

        //Connexion test
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
    }

    /**
     * Add items into base menu.
     */
    private void addItemBaseMenu() {
        menuSettings.add(itemBaseSettings);
        menuSettings.add(itemConnexionTest);
        this.add(menuSettings);
    }

    /**
     * Set settings for account menu, with sign in and sign up.
     */
    private void setMenuAccountSettings() {
        addListenersAccountMenu();
        addItemAccountMenu();
    }

    /**
     * Add listeners in all items in account menu.
     */
    private void addListenersAccountMenu() {
        // Sign in
        itemSignIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignin);
            }
        });

        // Sign up 
        itemSignUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignup);
            }
        });
    }

    /**
     * Add items into account menu.
     */
    private void addItemAccountMenu() {
        menuAccount.add(itemSignIn);
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
