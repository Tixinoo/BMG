package model;

public abstract class Question {

	// ----- ATTRIBUTES -----

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

	// ----------------------

	// ------- METHODS ------

	/**
     *
     */
	public void setText(String Qtext) {
		if (Qtext != null)
			this.text = Qtext;
	}

	/**
   *
   */
	public void setDifficulty(int Qdifficulty) {
		if (Qdifficulty >= 0)
			this.difficulty = Qdifficulty;
	}

	// ----------------------

}