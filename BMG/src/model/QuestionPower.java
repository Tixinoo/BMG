package model;

import java.util.ArrayList;


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
}
