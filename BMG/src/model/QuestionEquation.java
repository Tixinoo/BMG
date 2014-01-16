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
		String res = "		QuestionFraction";
		res = res + "\n			Text: " + this.text;
		res = res + "\n			Difficulty: " + this.difficulty;
		return res;
	}

	// ----------------------

}