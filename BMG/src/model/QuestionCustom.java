package model;

import java.util.*;

public class QuestionCustom<SolutionType> extends Question {

	// ----- ATTRIBUTES -----

	// Inherited

	/**
	 * List of the name of the attributes
	 */
	private ArrayList<String> names;

	/**
	 * List of the types of the attributes
	 */
	private ArrayList<String> types;

	/**
	 * List of the values of the attributes
	 */
	private ArrayList<Object> values;

	/**
	 * Solution of the question
	 */
	private SolutionType solution;

	// ----------------------

	// ---- CONSTRUCTORS ----

	/**
	 * This constructor creates the simplest question for a calculation
	 */
	public QuestionCustom() {

	}

	/**
	 * This constructor creates a question with the text given in parameter
	 */
	public QuestionCustom(String QCtext) {

	}

	/**
	 * This constructor creates a question with the text and the difficulty
	 * given in parameters
	 */
	public QuestionCustom(String QCtext, int QCdifficulty) {

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
	 * True if the object given in parameter equals the solution
	 */
	public boolean checkAnswer(SolutionType QCanswer) {
		boolean res = false;
		if (QCanswer != null) {
			if (this.solution == QCanswer)
				res = true;
		}
		return res;
	}

	/**
	 * Display a question with an equation
	 */
	public String toString() {
		String res = "		QuestionCustom";
		res = res + "\n			Text: " + this.text;
		res = res + "\n			Difficulty: " + this.difficulty;
		return res;
	}

	// ----------------------
	
	// ----- DB METHODS -----

	/* GETTERS */
	public String get()
	{
	    return "";
	}

	/* SETTERS */
	public String set()
	{
	    return "";
	}

	/* MISE A JOURS */
	public String insert()
	{
	    return "";
	}

	public String update()
	{
	    return "";
	}

	public String delete()
	{
	    return "";
	}

	/* FINDERS */
	public static String findById(int id)
	{
	    return "";
	}
	
	// ----------------------
	
}
