package user;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private int id_u;
    private int id_ut;
    private String fname_u;
    private String lname_u;
    private String school_u;
    private String email_u;
    private String pass_u;
    private boolean connected_u;

    /* CONSTRUCTOR */
    public User(int idut, String fnameu, String lnameu, String schoolu, String emailu, String passu) 
    {
	id_ut = idut;
	fname_u = fnameu;
	lname_u = lnameu;
	school_u = schoolu;
	email_u = emailu;
	pass_u = passu;
	connected_u = false;
    }

    public int getId_u() {
	return id_u;
    }

    public void setId_u(int id_u) {
	this.id_u = id_u;
    }

    public int getId_ut() {
	return id_ut;
    }

    public void setId_ut(int id_ut) {
	this.id_ut = id_ut;
    }

    public String getFname_u() {
	return fname_u;
    }

    public void setFname_u(String fname_u) {
	this.fname_u = fname_u;
    }

    public String getLname_u() {
	return lname_u;
    }

    public void setLname_u(String lname_u) {
	this.lname_u = lname_u;
    }

    public String getSchool_u() {
	return school_u;
    }

    public void setSchool_u(String school_u) 
    {
	this.school_u = school_u;
    }

    public String getEmail_u() 
    {
	return email_u;
    }

    public void setEmail_u(String email_u) 
    {
	this.email_u = email_u;
    }

    public String getPass_u() {
	return pass_u;
    }

    public void setPass_u(String pass_u) {
	this.pass_u = pass_u;
    }

    public boolean isConnected_u() {
	return connected_u;
    }

    public void setConnected_u(boolean connected_u) {
	this.connected_u = connected_u;
    }

    /* MISE A JOURS */
    public String insert() {
	String query = "INSERT INTO User (id_ut,fname_u,lname_u,school_u,email_u,pass_u,connected_u) VALUES (?,?,?,?,?,?,?)";
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	    p_statement.setInt(1,this.id_ut);
	    p_statement.setString(2,this.fname_u);
	    p_statement.setString(3,this.lname_u);
	    p_statement.setString(4,this.school_u);
	    p_statement.setString(5,this.email_u);
	    p_statement.setString(6,this.pass_u);
	    p_statement.setBoolean(7,this.connected_u);
	    p_statement.executeUpdate(query);
	    ResultSet rs = p_statement.getGeneratedKeys();
	    if (rs.next()) this.id_u = rs.getInt(1);
		    
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }

    public String update() {
	return "";
    }

    public String delete() {
	return "";
    }

    /* FINDERS */
    public static String findById(int id) {
	return "";
    }
}
