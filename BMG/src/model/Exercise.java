package model;

import java.util.*;

public class Exercise {

    // ----- ATTRIBUTES -----
    
    /**
     * Exercise's id
     */
    private int id;
    
    /**
     * Exercise's title
     */
    private String title;
    
    /**
     * Exercise's statement
     */
    private Wording wording;

    /**
     * Exercise's questions
     */
    private ArrayList<Question> questions;

    /**
     * Exercise's type
     */
    private String type;

    /**
     * Exercise's difficulty '0' corresponds to an unknown difficulty '1'
     * corresponds to the easiest difficulty
     */
    private int difficulty;

    /**
     * True if the exercise is ready to be used, so if the exercise has (at
     * least): - 1 statement (not null); - 1 question in the list of questions;
     * - a type; - a difficulty;
     */
    private boolean ready;

	// ----------------------
	// ---- CONSTRUCTORS ----
    /**
     * This constructor creates a completely random exercise
     */
    public Exercise() {
        this.id = -1;
        this.title = "Exercise";
        this.wording = null;
        this.questions = new ArrayList<Question>();
        this.type = "";
        this.difficulty = 0;
        this.ready = false;
    }

    /**
     * This constructor creates an exercise of the type given in parameter All
     * others characteristics are random
     */
    public Exercise(String Etype) {
        this.id = -1;
        this.title = "Exercise";
        this.wording = null;
        this.questions = new ArrayList<Question>();
        this.difficulty = 0;
        if (Etype != null) {
            this.type = Etype;
        } else {
            this.type = null;
        }
        this.ready = false;
    }

    /**
     * This constructor creates an exercise of the type and of a difficulty
     * given in parameters
     */
    public Exercise(String Etype, int Edifficulty) {
        this.id = -1;
        this.title = "Exercise";
        this.wording = null;
        this.questions = new ArrayList<Question>();
        this.type = "";
        if (Edifficulty >= 0) {
            this.difficulty = Edifficulty;
        } else {
            this.difficulty = 0;
        }
        this.ready = false;
    }

    // ----------------------
    // ------- METHODS ------
    
    /**
     * Generate a random exercise with 10 randoms questions,
     * type must be precised in the attribute.
     */
    public void generate() {
        if (this.type != "") {
            switch(type) {
                case "calculation":
                    for(int i=0;i<10;i++) {
                        QuestionCalculation qc = new QuestionCalculation();
                        qc.generate();
                        this.addQuestion(qc);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Add a question to the exercise
     */
    public void addQuestion(Question Equestion) {
        if (Equestion != null) {
            this.questions.add(Equestion);
            this.update_ready();
        }
    }

    /**
     * Update the attribute ready
     */
    public void update_ready() {
        if ((this.wording != null) && (!this.questions.isEmpty())
                && (this.type != null) && (this.difficulty >= 0)) {
            this.ready = true;
        }
    }

    /**
     * True if the exercise is ready to be used
     */
    public boolean isReady() {
        return this.ready;
    }

    /**
     *
     */
    public void setStatement(Wording Estatement) {
        if (Estatement != null) {
            this.wording = Estatement;
            this.update_ready();
        }
    }

    /**
     *
     */
    public void setType(String Etype) {
        if (Etype != null) {
            this.type = Etype;
            this.update_ready();
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     *
     */
    public void setDifficulty(int Edifficulty) {
        if (Edifficulty >= 0) {
            this.difficulty = Edifficulty;
            this.update_ready();
        }
    }

    /**
     * Display an exercise
     */
    public String toString() {
        String res = "--> EXERCISE";
        res = res + "\n	Statement: " + this.wording;
        res = res + "\n	Type: " + this.type;
        res = res + "\n	Difficulty: " + this.difficulty;
        res = res + "\n	Ready: " + this.ready;
        res = res + "\n	Questions: \n";
        Iterator<Question> it = this.questions.iterator();
        while (it.hasNext()) {
            res = res + it.next() + "\n";
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
