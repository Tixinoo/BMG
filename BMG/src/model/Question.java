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
    
    public Question(String textq, int diffq)
     {
    		text = textq;
    		difficulty = diffq;
     }
    
     public Question(int idq, String textq, int diffq)
     {
    		id = idq;
    		text = textq;
    		difficulty = diffq;
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

    public int getID() {
		return id;
	}
    
	public void setID(int id) {
		this.id = id;
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
		String res = "<" + id + "><$<" + text + ">$><" + difficulty + ">";
		return res;
	}
    
    public String getText() {
		return text;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public static void decode(Question qtn, String str) {
    	if (str.charAt(0) == '<') {
    		int i = 1;
    		while (str.charAt(i) != '>') {
    			i++;
    		}
    		if (i > 1) {
    			qtn.setID(Integer.valueOf(str.substring(1, i)));
    		} else {
    			qtn.setID(-1);
    		}
    		
    		i++;
    		int beginning = i;
            if (str.substring(i, i+3).compareTo("<$<") == 0) {
                while (str.substring(i, i+3).compareTo(">$>") != 0) {
                    i++;
                }
                if (beginning < i-1) {
                	qtn.setText(str.substring(beginning + 3, i));
                } else {
                	qtn.setText(null);
                }
                i += 3;
                
                beginning = i;
                if (str.charAt(0) == '<') {
            		while (str.charAt(i) != '>') {
            			i++;
            		}
            		if (i-1 > beginning) {
            			qtn.setDifficulty(Integer.valueOf(str.substring(beginning+1, i)));
            		} else {
            			qtn.setDifficulty(0);
            		}
            		i++;
            		str = str.substring(i);
                }
            }
    	}
    }

	// ----------------------
}
