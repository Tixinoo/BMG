package model;

public abstract class Question {

    // ----- ATTRIBUTES -----
    
    /**
     * Question'id
     */ 
    protected int id;

     /**
     * Question's text
     */
    protected String text;

    /**
     * Question's difficulty '0' corresponds to an unknow difficulty
     * '1' corresponds to the easiest difficulty
     */
    protected int difficulty;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    public Question() {
        this.id = -1;
    }
    
    
    // ----------------------
    
    // ------- METHODS ------
    
    /**
     *
     */
    public void setText(String Qtext) {
        if (Qtext != null) {
            this.text = Qtext;
        }
    }

    /**
     *
     */
    public void setDifficulty(int Qdifficulty) {
        if (Qdifficulty >= 0) {
            this.difficulty = Qdifficulty;
        }
    }
    
    public String encode() {
		String res = "<" + id + "><" + text + "><" + difficulty + ">";
		return res;
	}

	// ----------------------
}
