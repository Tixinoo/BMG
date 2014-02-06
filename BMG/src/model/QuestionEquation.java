package model;

import java.util.*;

public class QuestionEquation extends Question {

    // ----- ATTRIBUTES -----
    
    // Inherited
    
    /**
     * Operands of the equation (without unknowns)
     */
    private ArrayList<Integer> operands;

    /**
     * Placements of the unknowns in the equation
     */
    private ArrayList<Boolean> unknowns;

    /**
     * Operators of the equation ('=' included)
     */
    private ArrayList<Character> operators;

    /**
     * Length of the equation
     */
    private int length;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    /**
     * This constructor creates the simplest question for a calculation
     */
    public QuestionEquation() {
        super();

    }

    /**
     * This constructor creates a question with the text given in parameter
     */
    public QuestionEquation(String QCtext) {

    }

    /**
     * This constructor creates a question with the text and the difficulty
     * given in parameters
     */
    public QuestionEquation(String QCtext, int QCdifficulty) {

    }

    // ----------------------
    
    // ------- METHODS ------
    
    // Inherited
    
    /**
     * Generate a random question with an equation
     */
    public void generate() {

    }

    /**
     * Generate a random question with an equation with the length given in
     * parameter
     */
    public void generate(int QClength) {

    }

    /**
     * Solve a question with an equation
     */
    public double solve() {
        double res = 0;
        return res;
    }

    /**
     * Display a question with an equation
     */
    public String toString() {
        String res = "		QuestionEquation";
        res = res + "\n			Text: " + this.text;
        res = res + "\n			Difficulty: " + this.difficulty;
        return res;
    }

    public ArrayList<Integer> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }

    public ArrayList<Boolean> getUnknowns() {
        return unknowns;
    }

    public void setUnknowns(ArrayList<Boolean> unknowns) {
        this.unknowns = unknowns;
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

    /**
	 * Encode the current question (object) in a string which can recreate this question by the decode() method
	 * @return encoded question
	 */
	public String encode() {
		Iterator<Integer> itopd = operands.iterator();
		String res = "#QuestionEquation<";
		while (itopd.hasNext()) {
			res = res + itopd.next() + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + "><";
		Iterator<Boolean> itukn = unknowns.iterator();
		while (itukn.hasNext()) {
			res = res + itukn.next() + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + "><";
		Iterator<Character> itopt = operators.iterator();
		while (itopt.hasNext()) {
			res = res + itopt.next() + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + "><" + length + ">";
		res = res + super.encode();
		return res;
	}
	
	/**
	 * Decode the string generate by the encode() method of this class
	 * @param str encoded question
	 * @return decoded question (object)
	 */
	public static QuestionEquation decode(String str) {
		QuestionEquation res = null;
		if (str.substring(0,17).compareTo("#QuestionEquation") == 0) {
			res = new QuestionEquation();
			int i = 17;
			if (str.charAt(i) == '<') {
				while (str.charAt(i) != '>') {
					i++;
				}
				String[] tab = str.substring(18,i).split(":");
				ArrayList<Integer> tmp_opd = new ArrayList<Integer>();
				for (int x=0; x<tab.length; x++) {
					tmp_opd.add(Integer.valueOf(tab[x]));
				}
				assert tmp_opd.size() > 0 : "empty operands table";
				res.setOperands(tmp_opd);
				
				i++;
				int beginning = i;
				if (str.charAt(i) == '<') {
					while (str.charAt(i) != '>') {
						i++;
					}
					tab = str.substring(beginning+1,i).split(":");
					ArrayList<Boolean> tmp_ukn = new ArrayList<Boolean>();
					for (int x=0; x<tab.length; x++) {
						tmp_ukn.add(Boolean.valueOf(tab[x]));
					}
					assert tmp_ukn.size() > 0 : "empty unknowns table";
					res.setUnknowns(tmp_ukn);
				
					i++;
					beginning = i;
					if (str.charAt(i) == '<') {
						while (str.charAt(i) != '>') {
							i++;
						}
						tab = str.substring(beginning+1,i).split(":");
						ArrayList<Character> tmp_opt = new ArrayList<Character>();
						for (int x=0; x<tab.length; x++) {
							tmp_opt.add(tab[x].charAt(0));
						}
						assert tmp_opt.size() > 0 : "empty operators table";
						assert tmp_opt.size() == tmp_opt.size()+1 : "incorrect size of operators table";
						res.setOperators(tmp_opt);
						
						i++;
						beginning = i;
						if (str.charAt(i) == '<') {
							while (str.charAt(i) != '>') {
								i++;
							}
							int tmp_lth = Integer.valueOf(str.substring(beginning+1,i));
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
			} else {
				res =null;
			}
		}
		return res;
	}

    // ----------------------
    
    // ----- DB METHODS -----

    /* MISE A JOURS */
    public String insert() {
        return "";
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

    // ----------------------
}
