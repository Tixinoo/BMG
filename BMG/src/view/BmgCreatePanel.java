/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

// Here all imports needed for this class.
import database.BaseInformation;
import database.BaseSetting;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * class BmgCreatePanel
 *
 * @author Maxime Blaise
 */
public class BmgCreatePanel {

    /**
     * Simply empty constructor, because this class contains only static method.
     */
    public BmgCreatePanel() {

    }

    /**
     * This method create the main panel.
     *
     * @param fen
     * @param bs
     * @param width
     * @param height
     * @return
     */
    public static JPanel createMainPanel(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        // Some settings for this panel, size, color ...
        int nb = 5;
        String colortitle = "green";
        String colortext = "black";

        //Create the main panel
        JPanel pan = new JPanel();

        //Panel Exercises
        JPanel panExercises = new JPanel();
        panExercises.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panExercises.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Training with exercises !</p></html>"));
        panExercises.setLayout(new GridLayout(2, 2));

        //Button Generate in panel Exercises.
        panExercises.add(new BmgLabel("Automatically generate exercises : ", colortext));
        BmgButton bgenerate = new BmgButton("Generate");
        panExercises.add(bgenerate);

        //Button Practice in panel Exercises.
        panExercises.add(new BmgLabel("Let's practice here : ", colortext));
        BmgButton bpractice = new BmgButton("Practice");
        panExercises.add(bpractice);

        //Panel Account
        JPanel panAccount = new JPanel();
        panAccount.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panAccount.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Account setting !</p></html>"));
        panAccount.setLayout(new GridLayout(2, 2));

        //Add label
        panAccount.add(new BmgLabel("Sign in here : ", colortext));

        //Button Sign in in panel Account
        BmgButton bsignin = new BmgButton("Sign in");
        bsignin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignin);
            }
        });
        panAccount.add(bsignin);

        //Button Sign up in panel Account
        panAccount.add(new BmgLabel("You should create an account if you don't have ", colortext));
        BmgButton bsignup = new BmgButton("Sign up now !");
        bsignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSignup);
            }
        });
        panAccount.add(bsignup);

        //Panel Database Settings
        JPanel panSettings = new JPanel();
        panSettings.setPreferredSize(new Dimension(width - 100, ((height - 100) / nb)));
        panSettings.setBorder(BorderFactory.createTitledBorder("<html><p style=\"color: " + colortitle + ";\">Database setting !</p></html>"));
        panSettings.setLayout(new GridLayout(2, 2));

        //Add label
        panSettings.add(new BmgLabel("Change database settings : ", colortext));

        //Button Setting in panel Database Settings
        BmgButton bsettings = new BmgButton("Settings");
        bsettings.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fen.setPanel(BmgFrame.panSettings);
            }
        });
        panSettings.add(bsettings);

        //Add label and button test in panel Database settings
        panSettings.add(new BmgLabel("Test your database connexion : ", colortext));
        BmgButton btest = new BmgButton("-->Test");
        btest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                testConnection(bs);
            }
        });
        panSettings.add(btest);

        //Add all panels in main panel
        pan.add(panExercises);
        pan.add(panAccount);
        pan.add(panSettings);

        return pan;
    }

    /**
     * This method create the panel sign in.
     *
     * @param fen
     * @param bs
     * @param width
     * @param height
     * @return
     */
    public static JPanel createPanelSignin(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        //Some settings of this panel.
        int nb = 6;
        String labelcolor = "red";

        //Create this panel here
        JPanel pan = new JPanel();

        BmgLabel label = new BmgLabel("You have an account ? Sign in now ", labelcolor);
        label.setPreferredSize(new Dimension(width - 100, (height - 100) / (5 * nb)));
        pan.add(label, BorderLayout.NORTH);

        //Center panel, in which user can put information.
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(2, 2));
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));

        //TextField
        JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),};
        //Labels

        JLabel[] labels = {
            new JLabel("Email address : "),
            new JLabel("Password : "),};

        //Add text field and label into panels.
        for (int i = 0; i < labels.length; i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }

        //Create panel South , just for the moment a button.
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new BorderLayout());

        //Button sign in
        BmgButton buttonSignin = new BmgButton("Sign in now !");
        buttonSignin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                actionSignIn();

            }
        });

        panSouth.add(buttonSignin, BorderLayout.NORTH);

        //Add all panels into main panel.
        pan.add(panCenter, BorderLayout.CENTER);
        pan.add(panSouth, BorderLayout.SOUTH);

        return pan;
    }

    /**
     * This method create the panel sign up
     * 
     * @param fen
     * @param bs
     * @param width
     * @param height
     * @return 
     */
    public static JPanel createPanelSignup(BmgFrame fen, final BaseSetting bs, int width, int height) {
        //Some settings
        int nb = 2;
        String labelcolor = "red";
        
        //Create panel
        JPanel pan = new JPanel();

        BmgLabel label = new BmgLabel("Sign up now, for free of course : ", labelcolor);
        label.setPreferredSize(new Dimension(width - 100, (height - 100) / (2 * nb)));
        pan.add(label, BorderLayout.NORTH);

        //Center panel
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(6, 2));
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));
        
        //TextFields
        JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15)
        };
        
        //Labels
        JLabel[] labels = {
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel(""),
            new JLabel("")
        };

        //Add components to panel
        for (int i = 0; i < labels.length; i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }

        //Create panSouth, with button
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new BorderLayout());

        BmgButton buttonSignup = new BmgButton("Sign up now !");
        buttonSignup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                actionSignUp();

            }
        });

        panSouth.add(buttonSignup, BorderLayout.NORTH);

        //Add to panel sign up
        pan.add(panCenter, BorderLayout.CENTER);
        pan.add(panSouth, BorderLayout.SOUTH);

        return pan;
    }

    /**
     * This method create the panel settings.
     * 
     * @param fen
     * @param bs
     * @param width
     * @param height
     * @return 
     */
    public static JPanel createPanelSettings(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        //Some settings
        int nb = 2;
        
        //Create panel
        JPanel pan = new JPanel();
        
        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(width - 100, (height - 100) / (nb * 2)));
          
        //Center Panel
        JPanel panCenter = new JPanel();
        panCenter.setPreferredSize(new Dimension(width - 100, (height - 100) / nb));

        //TextFields
        final JTextField[] jtfs = {
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15),
            new JTextField(15)
        };
        
        //Labels
        JLabel[] labels = {
            new JLabel("Pilote : "),
            new JLabel("Driver : "),
            new JLabel("Database name : "),
            new JLabel("Login : "),
            new JLabel("Password : "),
            new JLabel("Url : ")
        };

        //Add components to panel
        panCenter.setLayout(new GridLayout(6, 2));
        for (int i = 0; i < jtfs.length; i++) {
            panCenter.add(labels[i]);
            panCenter.add(jtfs[i]);
        }

        //Button and label, to register
        JButton buttonConfirm = new JButton("Register information");
        final BmgLabel labelRes = new BmgLabel("Waiting ...", "green");
        buttonConfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new BaseInformation(jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText(), jtfs[5].getText());
                JOptionPane jop = new JOptionPane();
                JOptionPane.showMessageDialog(null, "Registration success !", "Database Connexion", JOptionPane.INFORMATION_MESSAGE);
                bs.setInfo();
            }
        });
        
        //Button and label, to test
        JButton buttonTest = new JButton("Connexion test");
        final BmgLabel labelTest = new BmgLabel("Waiting ...", "red");
        buttonTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new BaseInformation(jtfs[0].getText(), jtfs[1].getText(), jtfs[2].getText(), jtfs[3].getText(), jtfs[4].getText(), jtfs[5].getText());

                bs.setInfo();
                testConnection(bs);

                /*if(bs.testerConnexion()) {
                 labelTest.set("Success !!");
                 } else {
                 labelTest.set("Error !!");
                 }*/
            }

        });

        //
        jtfs[0].setText(bs.getBi().getDriver());
        jtfs[1].setText(bs.getBi().getNamedriver());
        jtfs[2].setText(bs.getBi().getDbname());
        jtfs[3].setText(bs.getBi().getLogin());
        jtfs[4].setText(bs.getBi().getPassword());
        jtfs[5].setText(bs.getBi().getUrl());

        //PanSouth, with button confirm and test
        JPanel panSouth = new JPanel();
        panSouth.add(buttonConfirm);
        panSouth.add(buttonTest);
        
        
        //Add panels to main panel
        pan.add(label, BorderLayout.NORTH);
        pan.add(panCenter, BorderLayout.CENTER); 
        pan.add(panSouth, BorderLayout.SOUTH);
        
        return pan;
    }

    /**
     * Test connection and print a popup which print result.
     * 
     * @param bs 
     */
    public static void testConnection(BaseSetting bs) {

        JOptionPane jop = new JOptionPane();
        
        if (bs.testerConnexion()) {
            //Success
            JOptionPane.showMessageDialog(null, "Success !", "Database Connexion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Error
            JOptionPane.showMessageDialog(null, "Error !", "Database Connexion", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method who create panel AboutUs, which print some information about our
     * team.
     *
     * @param fen
     * @param bs
     * @param width
     * @param height
     * @return
     */
    public static JPanel createPanelAboutUs(final BmgFrame fen, final BaseSetting bs, int width, int height) {
        JPanel pan = new JPanel();

        String s = "<span style=\"color: red;\">About us : </span><br/><br/>";
        s += "We are 4 students of Technical High School called Université de Lorraine, in french.<br/>";
        s += "And I have no idea to continue this label ...";

        pan.add(new BmgLabel(s, "blue"));

        return pan;
    }

    /**
     * This method is called when user push sign in button.
     * 
     */
    public static void actionSignIn() {
        JOptionPane jop = new JOptionPane();
        JOptionPane.showMessageDialog(null, "Sign in success (or not) !", "Sign up information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called when user push sign up button.
     * 
     */
    public static void actionSignUp() {
        JOptionPane jop = new JOptionPane();
        JOptionPane.showMessageDialog(null, "Sign up success (or not) !", "Sign up information", JOptionPane.INFORMATION_MESSAGE);
    }
    //Old code, but still useful sometimes.

    /* public static JPanel createMainPanel2(int width, int height) {
     JPanel panPrincipal = new JPanel();
     panPrincipal.setLayout(new BorderLayout());

     JPanel pan = new JPanel();

     pan.setLayout(new GridLayout(5, 1));
     pan.add(new Button("PRACTICE"));
     pan.add(new Button("GENERATE"));

     Button bSettings = new Button("Settings");
     bSettings.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {

     //setPanel(new PanelSettings(bs.getBaseInformations(), fen()));
     }
     });
     Button bSignin = new Button("Sign in");
     bSignin.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
     // setPanel(new PanelSignin(bs, fen()));
     }
     });
     Button bConnexion = new Button("Connexion");
     bConnexion.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
     // setPanel(new PanelConnexion(bs, fen()));
     }
     });
     pan.add(bSettings);
     pan.add(bSignin);
     pan.add(bConnexion);

     JPanel panHaut = new JPanel();
     //panHaut.setLayout(new GridLayout(2,1));
     panHaut.setLayout(new BoxLayout(panHaut, BoxLayout.PAGE_AXIS));

     panPrincipal.add(panHaut, BorderLayout.NORTH);
     panPrincipal.add(pan, BorderLayout.CENTER);
     return panPrincipal;
     }*/
}
