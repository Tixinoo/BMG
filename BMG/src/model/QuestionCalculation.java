package model;

import java.util.*;

public class QuestionCalculation extends Question {

	// ----- ATTRIBUTES -----

	// Inherited

	/**
	 * Operands of the calculation
	 */
	private ArrayList<Integer> operands;

	/**
	 * Operators of the calculation
	 */
	private ArrayList<Character> operators;

	/**
	 * Length of the calculation
	 */
	private int length;

	// ----------------------

	// ---- CONSTRUCTORS ----

	/**
	 * This constructor creates the simplest question for a calculation
	 */
	public QuestionCalculation() {
		this.text = "Calculate.";
		this.difficulty = 0;
		this.operands = new ArrayList<Integer>();
		this.operators = new ArrayList<Character>();
		this.length = 0;
	}

	/**
	 * This constructor creates a question with the text given in parameter
	 */
	public QuestionCalculation(String QCtext) {
		if (QCtext != null)
			this.text = QCtext;
		else
			this.text = "...";
		this.difficulty = 0;
		this.operands = new ArrayList<Integer>();
		this.operators = new ArrayList<Character>();
		this.length = 0;
	}

	/**
	 * This constructor creates a question with the text and the difficulty
	 * given in parameters
	 */
	public QuestionCalculation(String QCtext, int QCdifficulty) {
		if (QCtext != null)
			this.text = QCtext;
		else
			this.text = "...";
		if (QCdifficulty >= 0)
			this.difficulty = QCdifficulty;
		else
			this.difficulty = 0;
		this.operands = new ArrayList<Integer>();
		this.operators = new ArrayList<Character>();
		this.length = 0;
	}

	// ----------------------

	// ------- METHODS ------

	// Inherited

	/**
	 * Generate a random question of calculation
	 */
	public void generate() {
		char[] possible_operators = { '+', '-', '*', '/' };
		this.length = (int) (Math.random() * 10) + 2;
		System.out.println("	Random length: " + this.length);
		for (int i = 0; i < this.length; i++) {
			this.operands.add((int) (Math.random() * 20) + 1);
			if (i < this.length - 1)
				this.operators
						.add(possible_operators[(int) (Math.random() * 4)]);
		}
	}

	/**
	 * Generate a random question of calculation with the length given in
	 * parameter
	 */
	public void generate(int QClength) {
		char[] possible_operators = { '+', '-', '*', '/' };
		this.length = 2;
		if (QClength > 0)
			this.length = QClength;
		System.out.println("	Chosen length: " + this.length);
		for (int i = 0; i < this.length; i++) {
			this.operands.add((int) (Math.random() * 20) + 1);
			if (i < length - 1)
				this.operators
						.add(possible_operators[(int) (Math.random() * 4)]);
		}
	}

	/**
	 * Solve a question of calculation
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
			if (i > 0)
				old_operator = (char) (operators_array[i - 1]);
			if (operator == '*' || operator == '/') {
				if (operator == '*') {
					operands_array[i + 1] = (double) (operands_array[i])
							* (double) (operands_array[i + 1]);
					if (old_operator == '-')
						operands_array[i + 1] = (double) operands_array[i + 1]
								* (-1.0);
					// System.out.println("res*: "+operands_array[i+1]);
				} else {
					operands_array[i + 1] = (double) (operands_array[i])
							/ (double) (operands_array[i + 1]);
					if (old_operator == '-')
						operands_array[i + 1] = (double) operands_array[i + 1]
								* (-1.0);
					// System.out.println("res/: "+operands_array[i+1]);
				}
				if (i > 0)
					operators_array[i] = '+';
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
	 * Display a question of calculation
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

	// ----------------------

}