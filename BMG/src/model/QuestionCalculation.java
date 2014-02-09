package model;

import database.BaseSetting;
import interfaces.iDbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionCalculation extends Question implements iDbManager {

    // ----- ATTRIBUTES -----
    // Inherited
    /**
     * Operands of the calculation.
     */
    private ArrayList<Integer> operands;

    /**
     * Operators of the calculation.
     */
    private ArrayList<Character> operators;

    /**
     * Length of the calculation.
     */
    private int length;

	// ----------------------
    // ---- CONSTRUCTORS ----
    /**
     * This constructor creates the simplest question,
     * for a calculation.
     */
    public QuestionCalculation() {
        super();
        this.text = "Calculate.";
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    /**
     * This constructor creates a question,
     * with the text given in parameter.
     */
    public QuestionCalculation(String QCtext) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    /**
     * This constructor creates a question,
     * with the text and the difficulty given in parameters.
     */
    public QuestionCalculation(String QCtext, int QCdifficulty) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        if (QCdifficulty >= 0) {
            this.difficulty = QCdifficulty;
        } else {
            this.difficulty = 0;
        }
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    QuestionCalculation(String textqc, int diffqc, ArrayList<Integer> operandsqc, ArrayList<Character> operatorsqc, int lengthqc)
    {
	super();
	text = textqc;
	difficulty = diffqc;
	operands = operandsqc;
	operators = operatorsqc;
	length = lengthqc;
    }
    
    QuestionCalculation(int idqc, String textqc, int diffqc, ArrayList<Integer> operandsqc, ArrayList<Character> operatorsqc, int lengthqc)
    {
	super();
	id = idqc;
	text = textqc;
	difficulty = diffqc;
	operands = operandsqc;
	operators = operatorsqc;
	length = lengthqc;
    }

    // ----------------------
    // ------- METHODS ------
    // Inherited
    /**
     * Generate a random question of calculation.
     */
    public void generate() {
        char[] possible_operators = {'+', '-', '*', '/'};
        this.length = (int) (Math.random() * 10) + 2;
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * 4)]);
            }
        }
    }

    /**
     * Generate a random question of calculation,
     * with the length given in parameter.
     */
    public void generate(int QClength) {
        char[] possible_operators = {'+', '-', '*', '/'};
        this.length = 2;
        if (QClength > 0) {
            this.length = QClength;
        }
        System.out.println("	Chosen length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * 4)]);
            }
        }
    }

    /**
     * Generate a random question of calculation,
     * Operators are choosen in the ArrayList given in parameter.
     */
    public void generate(ArrayList<Character> QCoperators) {
        Character[] possible_operators = new Character[QCoperators.size()];
        possible_operators = QCoperators.toArray(possible_operators);
        this.length = (int) (Math.random() * 10) + 2;
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * QCoperators.size())]);
            }
        }
    }
    
    /**
     * Generate a random question of calculation,
     * with the length given in parameter,
     * Operators are choosen in the ArrayList given in parameter.
     */
    public void generate(ArrayList<Character> QCoperators, int QClength) {
        Character[] possible_operators = new Character[QCoperators.size()];
        possible_operators = QCoperators.toArray(possible_operators);
        this.length = 2;
        if (QClength > 0) {
            this.length = QClength;
        }
        System.out.println("	Chosen length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * QCoperators.size())]);
            }
        }
    }

    /**
     * Solve a question of calculation.
     */
    public double solve() {
        double res = 0;
        Object[] operands_array = new Object[this.operands.size()];
        operands_array = this.operands.toArray();
        Object[] operators_array = new Object[this.operators.size()];
        operators_array = this.operators.toArray();
        char operator, old_operator;
        int i;
        for (i = 0; i < operands_array.length; i++) {
            operands_array[i] = (double) ((int) (operands_array[i]));
        }
        for (i = 0; i < operands_array.length - 1; i++) {
            operator = (char) (operators_array[i]);
            old_operator = '+';
            if (i > 0) {
                old_operator = (char) (operators_array[i - 1]);
            }
            if (operator == '*' || operator == '/') {
                if (operator == '*') {
                    operands_array[i + 1] = (double) (operands_array[i])
                            * (double) (operands_array[i + 1]);
                    if (old_operator == '-') {
                        operands_array[i + 1] = (double) operands_array[i + 1]
                                * (-1.0);
                    }
                    // System.out.println("res*: "+operands_array[i+1]);
                } else {
                    operands_array[i + 1] = (double) (operands_array[i])
                            / (double) (operands_array[i + 1]);
                    if (old_operator == '-') {
                        operands_array[i + 1] = (double) operands_array[i + 1]
                                * (-1.0);
                    }
                    // System.out.println("res/: "+operands_array[i+1]);
                }
                if (i > 0) {
                    operators_array[i] = '+';
                }
                operands_array[i] = 0.0;
            }
        }
        for (i = 0; i < operands_array.length - 1; i++) {
            operator = (char) (operators_array[i]);
            if (operator == '+' || operator == '-') {
                if (operator == '+') {
                    operands_array[i + 1] = (double) (operands_array[i])
                            + (double) (operands_array[i + 1]);
                    // System.out.println("res+: "+operands_array[i+1]);
                } else {
                    operands_array[i + 1] = (double) (operands_array[i])
                            - (double) (operands_array[i + 1]);
                    // System.out.println("res-: "+operands_array[i+1]);
                }
                operands_array[i] = 0.0;
            }

        }
        res = (double) (operands_array[operands_array.length - 1]);
        return res;
    }

    /**
     * Display a question of calculation.
     */
    public String toString() {
        String res = "		QuestionCalculation";
        res = res + "\n			Text: " + this.text;
        res = res + "\n			Difficulty: " + this.difficulty;
        res = res + "\n			Operands: " + this.operands;
        res = res + "\n			Operators: " + this.operators;
        res = res + "\n			Operation: ";
        Iterator<Integer> it_operands = this.operands.iterator();
        Iterator<Character> it_operators = this.operators.iterator();
        res = res + it_operands.next();
        while (it_operands.hasNext()) {
            res = res + it_operators.next() + it_operands.next();
        }
        // res = res + "\n-----------------------";
        return res;
    }

    public ArrayList<Integer> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }

    public ArrayList<Character> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<Character> operators) {
        this.operators = operators;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public String encodeOperands() {
        String res = new String();
        if (operands.size() > 0) {
            Iterator<Integer> itopd = operands.iterator();
            while (itopd.hasNext()) {
                res = res + itopd.next() + ":";
            }
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
    
    public String encodeOperators() {
        String res = new String();
        if (operators.size() > 0) {
            Iterator<Character> itopt = operators.iterator();
            while (itopt.hasNext()) {
                res = res + itopt.next() + ":";
            }
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    /**
     * Encode the current question (object) in a string which can recreate this question by the decode() method
     *
     * @return encoded question
     */
    public String encode() {
        
        String res = "#QuestionCalculaion<";
        res = res + encodeOperands();
        res = res + "><";
        res = res + encodeOperators();
        res = res + "><" + length + ">";
        res = res + super.encode();
        return res;
    }
    
    public static ArrayList<Integer> decodeOperands(String str) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        String[] tab = str.split(":");
        for (int x = 0; x < tab.length; x++) {
            res.add(Integer.valueOf(tab[x]));
        }
        assert res.size() > 0 : "empty operands table";
        return res;
    }
    
    public static ArrayList<Character> decodeOperators(String str) {
        ArrayList<Character> res = new ArrayList<Character>();
        String[] tab = str.split(":");
        for (int x = 0; x < tab.length; x++) {
            res.add(tab[x].charAt(0));
        }
        assert res.size() > 0 : "empty operators table";
        return res;
    }

    /**
     * Decode the string generate by the encode() method of this class
     *
     * @param str encoded question
     * @return decoded question (object)
     */
    public static QuestionCalculation decode(String str) {
        QuestionCalculation res = null;
        if (str.substring(0, 19).compareTo("#QuestionCalculaion") == 0) {
            res = new QuestionCalculation();
            int i = 19;
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    i++;
                }
                ArrayList<Integer> tmp_opd = decodeOperands(str.substring(20, i));
                res.setOperands(tmp_opd);

                i++;
                int beginning = i;
                if (str.charAt(i) == '<') {
                    while (str.charAt(i) != '>') {
                        i++;
                    }
                    ArrayList<Character> tmp_opt = decodeOperators(str.substring(beginning + 1, i));
                    assert tmp_opt.size() == tmp_opt.size() + 1 : "incorrect size of operators table";
                    res.setOperators(tmp_opt);

                    i++;
                    beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        int tmp_lth = Integer.valueOf(str.substring(beginning + 1, i));
                        assert tmp_lth < 0 : "negative length";
                        res.setLength(tmp_lth);

                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                    } else {
                        res = null;
                    }
                } else {
                    res = null;
                }
            } else {
                res = null;
            }
        }
        return res;
    }

    // ----------------------
    // ----- DB METHODS -----

    /* MISE A JOURS */
    public boolean insert(BaseSetting bs) 
    {
	Connection connection = bs.getConnection();
	
	try 
	{
	    String query = "INSERT INTO QuestionCalculation (text_qc,diff_qc,operands_qc,operators_qc,length_qc) VALUES (?,?,?,?,?)";
	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
	    p_statement.setString(1,this.text);
	    p_statement.setInt(2,this.difficulty);
	    p_statement.setString(3,this.encodeOperands());
	    p_statement.setString(4,this.encodeOperators());
	    p_statement.setInt(5,this.length);
	    p_statement.executeUpdate();
	    ResultSet rs = p_statement.getGeneratedKeys();
			
	    if (rs.next()) this.id = rs.getInt(1);		
	}  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return true;
    }

    public boolean update(BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
	try 
	{
	    if (this.id < 0)
	    {
		String query = "UPDATE QuestionCalculation SET (text_qc = ? , diff_qc = ? , operands_qc = ? , operators_qc = ? , length_qc = ?) WHERE id_qf = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setString(1,this.text);
		p_statement.setInt(2,this.difficulty);
		p_statement.setString(3,this.encodeOperands());
		p_statement.setString(4,this.encodeOperators());
		p_statement.setInt(5,this.length);
		p_statement.setInt(6,this.id);
		p_statement.executeUpdate();
	    }
	}  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return true;
    }

    public boolean delete(BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
	try 
	{
	    if (QuestionCalculation.findById(this.getID(), bs) != null)
	    {
		String query = "DELETE FROM QuestionCalculation WHERE id_qc = ?";
		PreparedStatement p_statement = connection.prepareStatement(query);
		p_statement.setInt(1,this.id);
		p_statement.executeUpdate();
	    }
	}  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return true;
    }

    /* FINDERS */
    public static QuestionCalculation findById(int id, BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
	QuestionCalculation questionCalculation = null;
	
	try 
	{
	    String query = "SELECT * FROM QuestionCalculation WHERE id_qc = ?";
	    PreparedStatement p_statement = connection.prepareStatement(query);
	    p_statement.setInt(1,id);
	    
	    ResultSet rs = p_statement.executeQuery();
	    
	    if (rs.next())
	    {
		int idqc = rs.getInt("id_qc");
		String textqc = rs.getString("text_qc");
		int diffqc = rs.getInt("diff_qc");
		String operandsqc = rs.getString("operands_qc");
		ArrayList<Integer> alioprd = QuestionCalculation.decodeOperands(operandsqc);
		String operatorsqc = rs.getString("operators_qc");
		ArrayList<Character> alcoprr = QuestionCalculation.decodeOperators(operatorsqc);
		int lengthqc = rs.getInt("length_qc");

		questionCalculation = new QuestionCalculation(idqc,textqc,diffqc,alioprd,alcoprr,lengthqc);
	    }
		    
	}  
	catch (SQLException sqle) 
	{
	    System.out.println("ERREUR");
	    sqle.printStackTrace();
	}
	
	return questionCalculation;
    }

    // ----------------------
}
