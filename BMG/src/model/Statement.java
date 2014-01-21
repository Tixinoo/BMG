package model;

public class Statement {

	// ----- ATTRIBUTES -----

	/**
	 * Statement's text
	 */
	private String text;

	/**
	 * Statement's values
	 */
	private Object[] values;

	// ----------------------

	// ---- CONSTRUCTORS ----

	/**
	 * This constructor creates the simplest statement
	 */
	public Statement() {
		this.text = "Answer the following questions.";
		this.values = new Object[0];
	}

	/**
	 * This constructor creates a statement with the text given in parameter
	 */
	public Statement(String Stext) {
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
	public Statement(String Stext, Object[] Svalues) {
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

}
