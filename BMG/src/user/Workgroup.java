/*
NOTES IMPORTANTES : [OK = test verifie ; ... = en cours ; / = non implementee]
insert : OK
update : OK
delete : OK
findById : OK
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

public class Workgroup 
{
    private int id_wg;
    private String name_wg;
    
    /* CONSTRUCTOR */
    public Workgroup(String namewg) 
    {
	name_wg = namewg;
    }
    
    public Workgroup(int idwg, String namewg)
    {
	id_wg = idwg;
	name_wg = namewg;
    }
    
    /* GETTERS & SETTERS */
    public int getId_wg() 
    {
	return id_wg;
    }

    public void setId_wg(int id_wg) 
    {
	this.id_wg = id_wg;
    }

    public String getName_wg() 
    {
	return name_wg;
    }

    public void setName_wg(String name_wg) 
    {
	this.name_wg = name_wg;
    }
    
    /* MISE A JOURS */
    public String insert()
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	try 
	{
	    String query = "INSERT INTO WorkGroup (name_wg) VALUE (?)";
	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	    p_statement.setString(1,""+this.name_wg+"");
	    p_statement.executeUpdate();
	    ResultSet rs = p_statement.getGeneratedKeys();
	    
	    if (rs.next()) this.id_wg = rs.getInt(1);
		    
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
	    if (this.id_wg < 0)
	    {
		String query = "UPDATE WorkGroup SET name_wg = ? WHERE id_wg = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setString(1,this.name_wg);
		p_statement.setInt(2,this.id_wg);
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
	    if (Workgroup.findById(this.getId_wg()) != null)
	    {
		String query = "DELETE FROM WorkGroup WHERE id_wg = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setInt(1,this.id_wg);
		p_statement.executeUpdate();
	    }
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return "OK";
    }

    /* FINDERS */
    public static Workgroup findById(int id) 
    {
	Database db = new Database();
	Connection connection = db.getConnection();
	
	Workgroup workGroup = null;
	
	try 
	{
	    String query = "SELECT * FROM WorkGroup WHERE id_wg = ?";
	    PreparedStatement p_statement = connection.prepareStatement(query);
	    p_statement.setInt(1,id);
	    
	    ResultSet rs = p_statement.executeQuery();
	    
	    if (rs.next())
	    {
		int idwg = rs.getInt("id_wg");
		String namewg = rs.getString("name_wg");
	    
		workGroup = new Workgroup(idwg,namewg);
	    }
		    
	} catch (SQLException ex) 
	{
	    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	return workGroup;
    }
}
