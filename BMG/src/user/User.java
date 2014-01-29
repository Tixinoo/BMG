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
    
    public User(int idu, int idut, String fnameu, String lnameu, String schoolu, String emailu, String passu, boolean connectedu) 
    {
	id_u = idu;
	id_ut = idut;
	fname_u = fnameu;
	lname_u = lnameu;
	school_u = schoolu;
	email_u = emailu;
	pass_u = passu;
	connected_u = connectedu;
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
    public String insert() 
    {	
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    String query = "INSERT INTO User (id_ut,fname_u,lname_u,school_u,email_u,pass_u,connected_u) VALUES (?,?,?,?,?,sha(?),?)";
	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	    p_statement.setInt(1,this.id_ut);
	    p_statement.setString(2,this.fname_u);
	    p_statement.setString(3,this.lname_u);
	    p_statement.setString(4,this.school_u);
	    p_statement.setString(5,this.email_u);
	    p_statement.setString(6,this.pass_u);
	    p_statement.setBoolean(7,this.connected_u);
	    p_statement.executeUpdate();
	    ResultSet rs = p_statement.getGeneratedKeys();
	    
	    if (rs.next()) this.id_u = rs.getInt(1);
		    
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }

    public String update() 
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    if (this.id_u < 0)
	    {
		String query = "UPDATE User SET SET id_ut = ? , fname_u = ? , lname_u = ? , school_u = ? , email_u = ? , pass_u = ? , connected_u = ?) WHERE id_u = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setInt(1,this.id_ut);
		p_statement.setString(2,this.fname_u);
		p_statement.setString(3,this.lname_u);
		p_statement.setString(4,this.school_u);
		p_statement.setString(5,this.email_u);
		p_statement.setString(6,this.pass_u);
		p_statement.setBoolean(7,this.connected_u);
		p_statement.setInt(8, this.id_u);
		p_statement.executeUpdate();
	    }
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }

    public String delete() 
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    if (findById(this.getId_u()) != null)
	    {
		String query = "DELETE FROM User WHERE id_u = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setInt(1,this.id_u);
		p_statement.executeUpdate();
	    }
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }

    /* FINDERS */
    public static User findById(int id) 
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	User user = null;
	
	try 
	{
	    String query = "SELECT * FROM User WHERE id_u = ?";
	    PreparedStatement p_statement = connection.prepareStatement(query);
	    p_statement.setInt(1,id);
	    
	    ResultSet rs = p_statement.executeQuery();;
	    
	    if (rs.next())
	    {
		int idu = rs.getInt("id_u");
		int idut = rs.getInt("id_ut");
		String fnameu = rs.getString("fname_u");
		String lnameu = rs.getString("lname_u");
		String schoolu = rs.getString("school_u");
		String emailu = rs.getString("email_u");
		String passu = rs.getString("pass_u");
		boolean connectedu = rs.getBoolean("connected_u");
	    
		user = new User(idu,idut,fnameu,lnameu,schoolu,emailu,passu,connectedu);
	    }
		    
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return user;
    }
}