package model;

import database.BaseSetting;
import java.util.*;

public class QuestionCustom<SolutionType> extends Question {

    // ----- ATTRIBUTES -----
    
    // Inherited
    
    /**
     * List of the name of the attributes.
     */
    private ArrayList<String> names;

    /**
     * List of the types of the attributes.
     */
    private ArrayList<String> types;

    /**
     * List of the values of the attributes.
     */
    private ArrayList<Object> values;

    /**
     * Solution of the question.
     */
    private SolutionType solution;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    /**
     * This constructor creates an empty question.
     */
    public QuestionCustom() {
        super();
        this.text = "Answer.";
        this.difficulty = 0;
        this.names = new ArrayList<String>();
        this.types = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.solution = null;
    }

    /**
     * This constructor creates a question,
     * with the text given in parameter.
     */
    public QuestionCustom(String QCtext) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        this.difficulty = 0;
        this.names = new ArrayList<String>();
        this.types = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.solution = null;
    }
    
    /**
     * This constructor creates a question,
     * with the text and the solution given in parameters.
     */
    public QuestionCustom(String QCtext, SolutionType QCsolution) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        this.difficulty = 0;
        this.names = new ArrayList<String>();
        this.types = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.solution = QCsolution;
    }

    /**
     * This constructor creates a question,
     * with the text and the difficulty given in parameters.
     */
    public QuestionCustom(String QCtext, int QCdifficulty) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        if (QCdifficulty >= 0) {
            this.difficulty = QCdifficulty;
        } else {
            this.difficulty = 0;
        }
        this.names = new ArrayList<String>();
        this.types = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.solution = null;
    }
    
    /**
     * This constructor creates a question,
     * with the text, the difficulty and the solution given in parameters.
     */
    public QuestionCustom(String QCtext, int QCdifficulty, SolutionType QCsolution) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        if (QCdifficulty >= 0) {
            this.difficulty = QCdifficulty;
        } else {
            this.difficulty = 0;
        }
        this.names = new ArrayList<String>();
        this.types = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.solution = QCsolution;
    }

    // ----------------------
    
    // ------- METHODS ------
    
    // Inherited

    /**
     * True if the object given in parameter equals the solution
     */
    public boolean checkAnswer(SolutionType QCanswer) {
        boolean res = false;
        if (QCanswer != null) {
            if (this.solution == QCanswer) {
                res = true;
            }
        }
        return res;
    }

    public void setSolution(SolutionType solution) {
        this.solution = solution;
    }    
    
    /**
     * Display a question custom.
     */
    public String toString() {
        String res = "		QuestionCustom";
        res = res + "\n                 Text: " + this.text;
        res = res + "\n                 Difficulty: " + this.difficulty;
        res = res + "\n                 Solution: " + this.solution;
        return res;
    }

    // ----------------------
    
    // ----- DB METHODS -----

    /* MISE A JOURS */
    public boolean insert(BaseSetting bs) 
    {
        return false;
    }

    public boolean update(BaseSetting bs) 
    {
        return false;
    }

    public boolean delete(BaseSetting bs) 
    {
        return false;
    }

    /* FINDERS */
    public static QuestionCustom findById(int id, BaseSetting bs) 
    {
        return null;
    }

    // ----------------------
}
