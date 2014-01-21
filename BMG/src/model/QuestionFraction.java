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
     * Generate a random question with calculation with the length given in parameter
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
		return res;
	}


  // ----------------------

}