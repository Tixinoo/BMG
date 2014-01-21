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
		return res;
	}
	
	// ----------------------

}