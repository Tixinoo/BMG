/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author blaise
 */
public class BmgMenuBar extends JMenuBar {
    JButton buttonIndex = new JButton("a");
    JMenu menuExercises = new JMenu("Exercises");
    JMenuItem itemGenerate = new JMenuItem("Generate");
    JMenuItem itemPractice = new JMenuItem("Practice");
    
    JMenu menuAccount = new JMenu("Account");
    JMenuItem itemSignIn = new JMenuItem("Sign in");
    JMenuItem itemSignUp = new JMenuItem("Sign up now !");
    
    JMenu menuSettings = new JMenu("Settings");
    JMenuItem itemBaseSettings = new JMenuItem("Base Settings");
    
    JMenu menuHelp = new JMenu("?");
    JMenuItem itemHelp = new JMenuItem("Help");
    JMenuItem itemAbout = new JMenuItem("About us");
    
    public BmgMenuBar(int width) {
        super();
        
        setMenuSettings(width);
    }
    
    private void setMenuSettings(int width) {
        this.setPreferredSize(new Dimension(width, 30));
        this.add(buttonIndex);
        menuExercises.add(itemGenerate);
        menuExercises.add(itemPractice);
        this.add(menuExercises);
        
        menuAccount.add(itemSignIn);
        menuAccount.add(itemSignUp);
        this.add(menuAccount);
        
        menuSettings.add(itemBaseSettings);
        this.add(menuSettings);
        
        menuHelp.add(itemHelp);
        menuHelp.add(itemAbout);
        this.add(menuHelp);
    }
}
