package model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author tixinoo
 */
public class Practice {
    
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
    
    public void updateSuccess() {
        this.success = (this.right_answers.size() * 100.0 * 1.0) / (this.wrong_answers.size() * 1.0); 
    }
    
}
