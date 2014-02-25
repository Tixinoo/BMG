/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Exercise;

/**
 *
 * @author blaise
 */
public class BmgPanelPractice {
    private Exercise e;
    JPanel panHaut = new JPanel();
    JPanel panCenter;
    BmgFrame fen;
    int iterateur = 0;
    
    public BmgPanelPractice(BmgFrame fen, Exercise e) {
        super();
        this.fen = fen;
        
        this.e = e;
        
        
        setPanel();
    }
    
    public void setPanel() {
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        
        
        this.setPanHaut();
        pan.add(panHaut, BorderLayout.NORTH);
        this.setPanCenter();
        pan.add(panCenter, BorderLayout.CENTER);
        
        fen.setPanel(pan);
    }
    
    public void setPanHaut() {
        //JPanel panHaut = new JPanel();
        panHaut.setLayout(new BorderLayout());
        
        String color1 = "black";
        String color2 = "green";
        panHaut.add(new JLabel("<html><p style=\"margin-left: 420px;\"><br/>You're practicing exercise " + e.getTitle() + "</p></html>"), BorderLayout.NORTH);
        
        panHaut.add(new JLabel("<html><p style=\"font-size: 12px;margin-left: 50px; color: "+color2+";\"><br/>Enonce : "+e.getWordingText() + "</p></html>"), BorderLayout.CENTER);
    }
    
    public void setPanCenter() {
        iterateur++;
        panCenter = new JPanel();
        
        panCenter.add(new JLabel("<html><p>Question "+iterateur+" / " + e.getNumberOfQuestions() + "</p><br/><p>"+e.getQuestionText(iterateur-1)+"</p>"));
       
        //Next
        JButton next = new JButton("Next");
        //Listener
        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Valeur de l'itérateur : " + iterateur);
                setPanel();
            }
        });
        //Add button
        panCenter.add(next);
        
        
        
        
        
    }
}
