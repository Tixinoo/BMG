/*
NOTES IMPORTANTES : [OK = test verifie ; ... = en cours ; / = non implementee]
insert : OK
update : ...
delete : ...
findById : ...
findByNom : /
*/

package user;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserType 
{
    private int id_ut;
    private String name_ut;
    
    /* CONSTRUCTOR */
    public UserType(String nameut) 
    {
	name_ut = nameut;
    }

    public int getId_ut() {
	return id_ut;
    }

    public void setId_ut(int id_ut) {
	this.id_ut = id_ut;
    }

    public String getName_ut() {
	return name_ut;
    }

    public void setName_ut(String name_ut) {
	this.name_ut = name_ut;
    }
    
    /* GETTERS */
    public String get()
    {
	return "";
    }
    
    /* SETTERS */
    public String set()
    {
	return "";
    }
    
    /* MISE A JOURS */
    public String insert()
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    String query = "INSERT INTO UserType (name_ut) VALUE (?)";
	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	    p_statement.setString(1,""+this.name_ut+"");
	    p_statement.executeUpdate();
	    ResultSet rs = p_statement.getGeneratedKeys();
	    
	    if (rs.next()) this.id_ut = rs.getInt(1);
		    
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }
    
    public String update()
    {
	return "";
    }
    
    public String delete()
    {
	return "";
    }
    
    /* FINDERS */
    public static String findById(int id)
    {
	return "";
    }
}
