package model;

public class Wording {

	// ----- ATTRIBUTES -----

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
		this.text = "Answer the following questions.";
		this.values = new Object[0];
	}

	/**
	 * This constructor creates a statement with the text given in parameter
	 */
	public Wording(String Stext) {
		if (Stext != null)
			this.text = Stext;
		else
			this.text = "...";
		this.values = new Object[0];
	}

	/**
	 * This constructor creates a statement with the text and the values given
	 * in parameters
	 */
	public Wording(String Stext, Object[] Svalues) {
		if (Stext != null)
			this.text = Stext;
		else
			this.text = "...";
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
		if (Stext != null)
			this.text = Stext;
	}

	/**
     *
     */
	public void setValues(Object[] Svalues) {
		if (this.values.length == Svalues.length)
			this.values = Svalues;
	}

	/**
	 * Display a statement
	 */
	public String toString() {
		String res = "";
		res = res + "\n		Text: " + this.text;
		res = res + "\n		Values: ";
		if (this.values.length == 0)
			res = res + "nothing";
		else {
			res = res + "\n";
			for (int i = 0; i < this.values.length; i++) {
				res = res + this.values[i] + "\n";
			}
		}
		// res = res + "\n-----------------------";
		return res;
	}

	// ----------------------
	
	// ----- DB METHODS -----

	/* MISE A JOURS */
	public String insert()
	{
	    return "";
	}

	public String update()
	{
	    return "";
	}

	public String delete()
	{
	    return "";
	}

	/* FINDERS */
	public static String findById(int id)
	{
	    return "";
	}
	
	// ----------------------
	
}
