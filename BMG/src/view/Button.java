/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Maxime
 */
public class Button extends JButton {
    
    public Button(String name) {
        super(name);
        
        this.setPreferredSize(new Dimension(150,40));
    }
}
