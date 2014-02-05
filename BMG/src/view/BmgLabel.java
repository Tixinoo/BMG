/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JLabel;

/**
 *
 * @author blaise
 */
public class BmgLabel extends JLabel {
    public BmgLabel(String message, String color) {
        super("<html><p style=\"color: "+color+"\">"+message+"</p></html>");
    }
}
