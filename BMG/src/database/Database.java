package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
    private Connection connection = null;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/BMG_db";
    private String login = "Joseph";
    private String password = "j0j0";
    
    public Database() {}
    
    public Database(String lgn, String pswd) 
    {
	login = lgn;
	password = pswd;
    }
    
    public boolean disconnect()
    {
	boolean res = false;
	
	try 
	{
	    connection.close();
	    res = connection.isClosed();
	} catch (SQLException sqle) 
	{
	    System.out.println("SQL Exception in disconnect method");
	    sqle.printStackTrace();
	} catch (Exception e) 
	{
	    System.out.println("Exception in disconnect method");
	    e.printStackTrace();
	}
	
	return res;
    }
    
    public boolean connect()
    {
	boolean res = false;
	
	try
	{
	    Class.forName(driver);
	    connection = DriverManager.getConnection(url,login,password);
	    res = !(connection.isClosed());
	}
	catch (SQLException sqle)
	{
	    System.out.println("SQL Exception in connect method");
	    sqle.printStackTrace();
	}
	catch (Exception e)
	{
	    System.out.println("Exception in connect method");
	    e.printStackTrace();
	}
	return res;
    }
    
    public Connection deconnection()
    {
	if (connection != null)
	    disconnect();
	
	return connection;
    }
    
    public Connection getConnection()
    {
	if (connection == null)
	    connect();
	    
	return connection;
    }

}
