package model;

import database.BaseSetting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author tixinoo
 */
public class Practice {
    
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
    
    public boolean insert(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
//	try {
//            String query = "INSERT INTO Practice (id_u,id_e,execution_date,execution_time,success,wrong_answers) VALUES (?,?,?,?,?,?)";
//            PreparedStatement p_statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//            p_statement.setInt(1, this.id_u);
//            p_statement.setInt(2, this.id_e);
//            p_statement.executeUpdate();
//            ResultSet rs = p_statement.getGeneratedKeys();
//
//            if (rs.next()) {
//                this.id_u = rs.getInt(1);
//		this.id_e = rs.getInt(2);
//            }
//            
//            return true;
//
//        }  
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return false;
    }
    
    public boolean update(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	return false;
    }
    
    public boolean delete(BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	return false;
    }
    
    public static Practice findById(int idu, int ide, BaseSetting bs)
    {
	Connection connection = bs.getConnection();
	
	Practice practice = null;
	
	return practice;
    }
    
}
