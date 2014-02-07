/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseSetting;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author blaise
 */
public class BmgFrameBegin {

    JDialog dialog = new JDialog();

    public BmgFrameBegin(BaseSetting bs, final BmgFrame fen) {
        if (bs.testerConnexion()) {

            JPanel pan = new JPanel();

            JPanel panHaut = new JPanel();
            panHaut.setLayout(new GridLayout(2, 2));
            JTextField saisiePseudo = new JTextField(15);
            JTextField saisiePass = new JTextField(15);
            panHaut.add(new JLabel("Pseudo : "));
            panHaut.add(saisiePseudo);
            panHaut.add(new JLabel("Password : "));
            panHaut.add(saisiePass);

            JPanel panSouth = new JPanel();
            panSouth.setLayout(new GridLayout(3, 1));
            BmgButton buttonSignin = new BmgButton("Sign in", 300, 40, Color.yellow);
            BmgButton buttonSignup = new BmgButton("Sign up", 300, 40, Color.yellow);
            BmgButton buttonLater = new BmgButton("No thank's, later", 300, 40, Color.yellow);

            buttonSignin.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane jop = new JOptionPane();
                    jop.showMessageDialog(null, "Maybe Connected, or not", "Connexion...", JOptionPane.INFORMATION_MESSAGE);

                    fermer();
                }
            });
            panSouth.add(buttonSignin);
            panSouth.add(buttonSignup);

            buttonLater.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    fen.setPanel(BmgFrame.panMain);
                    fermer();
                }
            });
            panSouth.add(buttonLater);

            pan.add(panHaut, BorderLayout.NORTH);
            pan.add(panSouth, BorderLayout.SOUTH);

            dialog.setContentPane(pan);
            dialog.setTitle("Would you want to connect ?");
            dialog.setContentPane(pan);
            dialog.setLocation(300, 300);
            dialog.setPreferredSize(new Dimension(400, 300));
            dialog.pack();
            dialog.setVisible(true);
        } else {
            JOptionPane jop = new JOptionPane();
            //Error when connecting
            String[] choix = {"Setting database now", "No thank's, maybe later"};
            int rang = jop.showOptionDialog(null,
                    "What would you want to do ?",
                    "Error database !",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choix,
                    choix[0]);

            if (rang == 0) {
                fen.setPanel(BmgFrame.panSettings);
            } else {
                fen.setPanel(BmgFrame.panMain);
            }
        }

    }

    public void fermer() {
        dialog.dispose();
    }

}
