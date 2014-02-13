package model;

import java.util.ArrayList;
import java.util.Iterator;


public class QuestionPower extends Question {
    // ----- ATTRIBUTES -----
    // Inherited
    /**
     * Operands of the power calculation.
     */
    private ArrayList<Integer> operands;

    /**
     * Operators of the power calculation.
     */
    private ArrayList<Character> operators;
    
    /**
     * Powers of power calculation
     */
    private ArrayList<Integer> powers;

    /**
     * Length of the calculation.
     */
    private int length;

	// ----------------------
    // ---- CONSTRUCTORS ----
    /**
     * This constructor creates the simplest question,
     * for a power calculation.
     */
    public QuestionPower() {
        super();
        this.text = "Calculate.";
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.powers = new ArrayList<Integer>();
        this.length = 0;
    }

    /**
     * This constructor creates a question,
     * with the text given in parameter.
     */
    public QuestionPower(String QPtext) {
        super();
        if (QPtext != null) {
            this.text = QPtext;
        } else {
            this.text = "...";
        }
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.powers = new ArrayList<Integer>();
        this.length = 0;
    }

    /**
     * This constructor creates a question,
     * with the text and the difficulty given in parameters.
     */
    public QuestionPower(String QPtext, int QPdifficulty) {
        super();
        if (QPtext != null) {
            this.text = QPtext;
        } else {
            this.text = "...";
        }
        if (QPdifficulty >= 0) {
            this.difficulty = QPdifficulty;
        } else {
            this.difficulty = 0;
        }
        this.operands = new ArrayList<Integer>();
        this.operators = new ArrayList<Character>();
        this.powers = new ArrayList<Integer>();
        this.length = 0;
    }

    QuestionPower(String textqc, int QPdiff, ArrayList<Integer> QPoperands, ArrayList<Character> QPoperators, ArrayList<Integer> QPpowers, int QPlength) {
        super();
        this.text = textqc;
        this.difficulty = QPdiff;
        this.operands = QPoperands;
        this.operators = QPoperators;
        this.powers = QPpowers;
        this.length = QPlength;
    }
    
    QuestionPower(int QPid, String QPtext, int QPdiff, ArrayList<Integer> QPoperands, ArrayList<Character> QPoperators, int QPlength) {
        super();
        this.id = QPid;
        this.text = QPtext;
        this.difficulty = QPdiff;
        this.operands = QPoperands;
        this.operators = QPoperators;
        this.length = QPlength;
    }

    // ----------------------
    // ------- METHODS ------
    // Inherited
    /**
     * Generate a random question with powers.
     */
    public void generate() {
        char[] possible_operators = {'+', '-', '*'};
        this.length = (int) (Math.random() * 10) + 2;
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            this.powers.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * 3)]);
            }
        }
    }

    /**
     * Generate a random question with powers, with the length given in parameter.
     */
    public void generate(int QPlength) {
        char[] possible_operators = {'+', '-', '*'};
        this.length = 2;
        if (QPlength > 0) {
            this.length = QPlength;
        }
        System.out.println("	Chosen length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            this.powers.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * 3)]);
            }
        }
    }

    /**
     * Generate a random question with powers, Operators are choosen in the ArrayList given in parameter.
     */
    public void generate(ArrayList<Character> QPoperators) {
        Character[] possible_operators = new Character[QPoperators.size()];
        possible_operators = QPoperators.toArray(possible_operators);
        this.length = (int) (Math.random() * 10) + 2;
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            this.powers.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * QPoperators.size())]);
            }
        }
    }

    /**
     * Generate a random question of powers, with the length given in parameter, Operators are choosen in the ArrayList given in parameter.
     */
    public void generate(ArrayList<Character> QPoperators, int QPlength) {
        Character[] possible_operators = new Character[QPoperators.size()];
        possible_operators = QPoperators.toArray(possible_operators);
        this.length = 2;
        if (QPlength > 0) {
            this.length = QPlength;
        }
        System.out.println("	Chosen length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            this.powers.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                this.operators.add(possible_operators[(int) (Math.random() * QPoperators.size())]);
            }
        }
    }
    
    /**
     * Display a question of power calculation
     */
    public String toString() {
        String res = "		QuestionFraction";
        res = res + "\n			Text:       " + this.text;
        res = res + "\n			Difficulty: " + this.difficulty;
        res = res + "\n			Operands:   " + this.operands;
        res = res + "\n			Powers:     " + this.powers;
        res = res + "\n			Operators:  " + this.operators;
        res = res + "\n			Operation:  ";
        Iterator<Integer> it_operands = this.operands.iterator();
        Iterator<Integer> it_powers = this.powers.iterator();
        Iterator<Character> it_operators = this.operators.iterator();
        res = res + "(" + it_operands.next() + "^" + it_powers.next() + ")";
        while (it_operands.hasNext()) {
            res = res + it_operators.next() + "(" + it_operands.next() + "^" + it_powers.next() + ")";
        }
        // res = res + "\n-----------------------";
        return res;
    }
    
}
