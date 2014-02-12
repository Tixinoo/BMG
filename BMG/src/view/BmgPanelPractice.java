/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JPanel;

/**
 *
 * @author blaise
 */
public class BmgPanelPractice extends JPanel {
    String filename = "";
    
    public BmgPanelPractice(String name) {
        super();
        this.filename = name;
        
        this.add(new BmgLabel(name, "blue"));
    }
}
