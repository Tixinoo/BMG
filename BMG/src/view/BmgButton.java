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
public class BmgButton extends JButton {
    
    public BmgButton(String name) {
        super(name);
        
        this.setPreferredSize(new Dimension(150,40));
        this.setBackground(Color.green);
    }
    
    public BmgButton(String name, int width, int height, Color color) {
        super(name);
        
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
    }
}
