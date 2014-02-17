package model;

import database.BaseSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import user.User;

/**
 *
 * @author tixinoo
 */
public class Practice {
    
    private int id_p;
    
    private int id_u;
    
    private int id_e;
    
    /**
     * 
     */
    private int execution_time;
    
    /**
     * 
     */
    private Date execution_date;
    
    /**
     * 
     */
    private double success;
    
    /**
     * 
     */
    private ArrayList<Integer> wrong_answers;
    
    /**
     * 
     */
    private ArrayList<Integer> right_answers;
    
    /**
     * 
     */
    private Exercise practiced_exercise;
    
    
    public Practice(Exercise e) {
        this.execution_time = 0;
        this.execution_date = new Date();
        this.success = 0.0;
        this.wrong_answers = new ArrayList<Integer>();
        this.right_answers = new ArrayList<Integer>();
        this.practiced_exercise = e;
    }
    
    public void addRight(int r) {
        this.right_answers.add(r);
    }
    
    public void addWrong(int w) {
        this.wrong_answers.add(w);
    }
    
    public void updateSuccess() {
        this.success = ( (double)this.right_answers.size() / ( (double)this.right_answers.size() + (double)this.wrong_answers.size() ) ) * 100.0;
    }

    public int getExecution_time() {
        return execution_time;
    }

    public Date getExecution_date() {
        return execution_date;
    }

    public double getSuccess() {
        return success;
    }

    public ArrayList<Integer> getWrong_answers() {
        return wrong_answers;
    }

    public ArrayList<Integer> getRight_answers() {
        return right_answers;
    }

    public Exercise getPracticed_exercise() {
        return practiced_exercise;
    }

    public void setExecution_time(int execution_time) {
        this.execution_time = execution_time;
    }
    
    public int getId_p()
    {
	return id_p;
    }
    
    public boolean insert(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	try {
            if (User.findById(this.id_u, bs) != null && Exercise.findById(id_e, bs) != null)
	    {
		
	    String query = "INSERT INTO Practice (id_u,id_e,execution_date,execution_time,success,wrong_answers) VALUES (?,?,?,?,?,?)";
            PreparedStatement p_statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            p_statement.setInt(1, this.id_u);
            p_statement.setInt(2, this.id_e);
	    p_statement.setString(3, "date");
	    p_statement.setString(4, "time");
	    p_statement.setDouble(5, this.success);
	    p_statement.setString(6, "wrong answers");
            p_statement.executeUpdate();
            ResultSet rs = p_statement.getGeneratedKeys();

            if (rs.next()) {
                this.id_p = rs.getInt(1);
            }
            
            return true;

	    }
        }  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return false;
    }
    
    public boolean update(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	try {
	    if (User.findById(this.id_u, bs) != null && Exercise.findById(id_e, bs) != null)
	    {
                String query = "UPDATE Practice SET (id_u = ? , id_e = ? , execution_date = ? , execution_time = ? , success = ? , wrong_answers = ?) WHERE id_p = ?";
                PreparedStatement p_statement = connection.prepareStatement(query);
                p_statement.setInt(1, this.id_u);
                p_statement.setInt(2, this.id_e);
                p_statement.setString(3, "date");
                p_statement.setString(4, "time");
                p_statement.setDouble(5, this.success);
                p_statement.setString(6, "wrong answers");
                p_statement.setInt(7, this.id_p);
                p_statement.executeUpdate();
	    }
        }  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return false;
    }
    
    public boolean delete(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	try {
            if (Practice.findById(this.getId_p(),bs) != null) {
                String query = "DELETE FROM Practice WHERE id_p = ?";
                PreparedStatement p_statement = connection.prepareStatement(query);
                p_statement.setInt(1, this.id_p);
                p_statement.executeUpdate();
            }
        } 
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return false;
    }
    
    public static Practice findById(int id_p, BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	Practice practice = null;
	
	try {
            String query = "SELECT * FROM Practice WHERE id_p = ?";
            PreparedStatement p_statement = connection.prepareStatement(query);
            p_statement.setInt(1, id_p);

            ResultSet rs = p_statement.executeQuery();

            if (rs.next()) {
                int idp = rs.getInt("id_p");
                int idu = rs.getInt("id_u");
                int ide = rs.getInt("id_e");
                String execd = rs.getString("execution_date");
                String exect = rs.getString("execution_time");
                double s = rs.getDouble("success");
                String wa = rs.getString("wrong_answers");

                /*constructeur*/
            }

        }  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return practice;
    }
    
        public static ArrayList<Practice> findByIds(int id_u, int id_e, BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	ArrayList<Practice> al_practice = new ArrayList<>();
	
	try {
            String query = "SELECT * FROM Practice WHERE id_u = ? AND id_e = ?";
            PreparedStatement p_statement = connection.prepareStatement(query);
            p_statement.setInt(1, id_u);
	    p_statement.setInt(2, id_e);
	    
            ResultSet rs = p_statement.executeQuery();

            while (rs.next()) {
                int idp = rs.getInt("id_p");
                int idu = rs.getInt("id_u");
                int ide = rs.getInt("id_e");
                String execd = rs.getString("execution_date");
                String exect = rs.getString("execution_time");
                double s = rs.getDouble("success");
                String wa = rs.getString("wrrong_answers");

                /*constructeur*/
		
		al_practice.add(null);
            }

        }  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return al_practice;
    }
    
}
