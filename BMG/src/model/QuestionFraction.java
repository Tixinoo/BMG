package model;

import java.util.*;

public class QuestionFraction extends Question {

    // ----- ATTRIBUTES -----
    
    // Inherited
    
    /**
     * Numerators of the calculation with fractions
     */
    private ArrayList<Integer> numerators;

    /**
     * Denominators of the calculation with fractions
     */
    private ArrayList<Integer> denominators;

    /**
     * Operators of the calculation with fractions
     */
    private ArrayList<Character> operators;

    /**
     * Length of the calculation with fractions
     */
    private int length;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    /**
     * This constructor creates the simplest question for a calculation
     */
    public QuestionFraction() {

    }

    /**
     * This constructor creates a question with the text given in parameter
     */
    public QuestionFraction(String QCtext) {

    }

    /**
     * This constructor creates a question with the text and the difficulty
     * given in parameters
     */
    public QuestionFraction(String QCtext, int QCdifficulty) {

    }

    // ----------------------
    
    // ------- METHODS ------
    
    // Inherited
    
    /**
     * Generate a random question with fraction
     */
    public void generate() {

    }

    /**
     * Generate a random question with calculation with the length given in
     * parameter
     */
    public void generate(int QClength) {

    }

    /**
     * Solve a question with fraction
     */
    public double solve() {
        double res = 0;
        return res;
    }

    /**
     * Display a question of calculation
     */
    public String toString() {
        String res = "		QuestionFraction";
        res = res + "\n			Text: " + this.text;
        res = res + "\n			Difficulty: " + this.difficulty;
        return res;
    }

    public ArrayList<Integer> getNumerators() {
        return numerators;
    }

    public void setNumerators(ArrayList<Integer> numerators) {
        this.numerators = numerators;
    }

    public ArrayList<Integer> getDenominators() {
        return denominators;
    }

    public void setDenominators(ArrayList<Integer> denominators) {
        this.denominators = denominators;
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
		Iterator<Integer> itnum = numerators.iterator();
		String res = "#QuestionFraction<";
		while (itnum.hasNext()) {
			res = res + itnum.next() + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + "><";
		Iterator<Integer> itdnm = denominators.iterator();
		while (itdnm.hasNext()) {
			res = res + itdnm.next() + ":";
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
	public static QuestionFraction decode(String str) {
		QuestionFraction res = null;
		if (str.substring(0,16).compareTo("#QuestionFraction") == 0) {
			res = new QuestionFraction();
			int i = 16;
			if (str.charAt(i) == '<') {
				while (str.charAt(i) != '>') {
					i++;
				}
				String[] tab = str.substring(17,i).split(":");
				ArrayList<Integer> tmp_num = new ArrayList<Integer>();
				for (int x=0; x<tab.length; x++) {
					tmp_num.add(Integer.valueOf(tab[x]));
				}
				assert tmp_num.size() > 0 : "empty numerators table";
				res.setNumerators(tmp_num);
				
				i++;
				int beginning = i;
				if (str.charAt(i) == '<') {
					while (str.charAt(i) != '>') {
						i++;
					}
					tab = str.substring(beginning+1,i).split(":");
					ArrayList<Integer> tmp_dnm = new ArrayList<Integer>();
					for (int x=0; x<tab.length; x++) {
						tmp_dnm.add(Integer.valueOf(tab[x]));
					}
					assert tmp_dnm.size() > 0 : "empty operators table";
					res.setDenominators(tmp_dnm);
				
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
							str = str.substring(i,str.length());
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
