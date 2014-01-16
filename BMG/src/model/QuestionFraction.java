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
    private ArrayList<Character> denominators;

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


  // ----------------------

}