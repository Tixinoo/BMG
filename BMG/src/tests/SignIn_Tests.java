package tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignIn_Tests
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("SignIn windows");
		JPanel jp = new JPanel();
		JPanel jpbis = new JPanel();
		BorderLayout bl = new BorderLayout();
		GridLayout gl = new GridLayout(5,2);
		final JLabel jl = new JLabel("SignIn here !");
		final JButton jb = new JButton("SignIn");
		final JLabel jl_fname = new JLabel("First name");
		final JTextField jtf_fname = new JTextField("Prenom");
		final JLabel jl_lname = new JLabel("Last name");
		final JTextField jtf_lname = new JTextField("NomDeFamille");
		final JLabel jl_school = new JLabel("School");
		final JTextField jtf_school = new JTextField("Ecole");
		final JLabel jl_email = new JLabel("Email");
		final JTextField jtf_email = new JTextField("email@exemple.fr");
		final JLabel jl_pass = new JLabel("Password");
		final JPasswordField jpf_pass = new JPasswordField("mdp");
		
		jb.addMouseListener
		(
		new MouseListener() 
		{
			public void mouseClicked(MouseEvent me) 
			{
				if (me.getSource() == jb)
				{
					String s_fname = jtf_fname.getText();
					String s_lname = jtf_lname.getText();
					String s_school = jtf_school.getText();
					String s_email = jtf_email.getText();
					String s_pass = jpf_pass.getText();
					int id = 0;
					jl.setText("Thanks and welcome "+s_fname+"! Your id is : "+id);
				}
			}
			
			public void mousePressed(MouseEvent me) {}
			
			public void mouseReleased(MouseEvent me) {}
			
			public void mouseDragged(MouseEvent me) {}
			
			public void mouseEntered(MouseEvent me) {}
			
			public void mouseExited(MouseEvent me) {}
		}
		);
		
		jpbis.setLayout(gl);
		
		jpbis.add(jl_fname);
		jpbis.add(jtf_fname);
		jpbis.add(jl_lname);
		jpbis.add(jtf_lname);
		jpbis.add(jl_school);
		jpbis.add(jtf_school);
		jpbis.add(jl_email);
		jpbis.add(jtf_email);
		jpbis.add(jl_pass);
		jpbis.add(jpf_pass);
		
		jp.setLayout(bl);
		
		jp.add(jl,BorderLayout.NORTH);
		jp.add(jpbis,BorderLayout.CENTER);
		jp.add(jb,BorderLayout.SOUTH);
		
		jf.add(jp);
		jf.setSize(400,200);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
