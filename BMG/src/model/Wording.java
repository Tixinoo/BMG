package model;

public class Wording {

    // ----- ATTRIBUTES -----
    
    /**
     * Wording's id
     */
    private int id;
    
    /**
     * Wording's text
     */
    private String text;

    /**
     * Wording's values
     */
    private Object[] values;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    /**
     * This constructor creates the simplest statement
     */
    public Wording() {
        this.id = -1;
        this.text = "Answer the following questions.";
        this.values = new Object[0];
    }

    /**
     * This constructor creates a statement with the text given in parameter
     */
    public Wording(String Stext) {
        this.id = -1;
        if (Stext != null) {
            this.text = Stext;
        } else {
            this.text = "...";
        }
        this.values = new Object[0];
    }

    /**
     * This constructor creates a statement with the text and the values given
     * in parameters
     */
    public Wording(String Stext, Object[] Svalues) {
        this.id = -1;
        if (Stext != null) {
            this.text = Stext;
        } else {
            this.text = "...";
        }
        this.values = new Object[Svalues.length];
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = Svalues[i];
        }
    }

	// ----------------------
	// ------- METHODS ------
    /**
     *
     */
    public void setText(String Stext) {
        if (Stext != null) {
            this.text = Stext;
        }
    }

    /**
     *
     */
    public void setValues(Object[] Svalues) {
        if (this.values.length == Svalues.length) {
            this.values = Svalues;
        }
    }

    /**
     * Display a statement
     */
    public String toString() {
        String res = "";
        res = res + "\n		Text: " + this.text;
        res = res + "\n		Values: ";
        if (this.values.length == 0) {
            res = res + "nothing";
        } else {
            res = res + "\n";
            for (int i = 0; i < this.values.length; i++) {
                res = res + this.values[i] + "\n";
            }
        }
        // res = res + "\n-----------------------";
        return res;
    }
    
    public String encode() {
		String res = "#Wording<$<";
		res = text;
		res = res + ">$><";
		for (int i = 0; i<values.length; i++) {
			res = res + values[i] + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + ">";
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
