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
        char[] possible_operators = {'+', '-', '*', '/'};
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
        String res = "		QuestionPower";
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
    
    public ArrayList<Integer> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }

    public ArrayList<Integer> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<Integer> denominators) {
        this.powers = denominators;
    }

    public ArrayList<Character> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<Character> operators) {
        this.operators = operators;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public String encodeOperands() {
        String res = new String();
		Iterator<Integer> itnum = operands.iterator();
        while (itnum.hasNext()) {
			res = res + itnum.next() + ":";
		}
		res = res.substring(0, res.length()-1);
        return res;
    }
    
    public String encodePowers() {
        String res = new String();
        Iterator<Integer> itdnm = powers.iterator();
		while (itdnm.hasNext()) {
			res = res + itdnm.next() + ":";
		}
		res = res.substring(0, res.length()-1);
        return res;
    }
    
    public String encodeOperators() {
        String res = new String();
        Iterator<Character> itopt = operators.iterator();
		while (itopt.hasNext()) {
			res = res + itopt.next() + ":";
		}
		res = res.substring(0, res.length()-1);
        return res;
    }

    /**
	 * Encode the current question (object) in a string which can recreate this question by the decode() method
	 * @return encoded question
	 */
	public String encode() {
		String res = "#QuestionPower<";
        res = res + encodeOperands();
		res = res + "><";
		res = res + encodePowers();
		res = res + "><";
		res = res + encodeOperators();
		res = res + "><" + length + ">";
		res = res + super.encode();
		return res;
	}
    
    public static ArrayList<Integer> decodeOperands(String str) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        String[] tab = str.split(":");
        for (int x=0; x<tab.length; x++) {
            res.add(Integer.valueOf(tab[x]));
        }
        assert res.size() > 0 : "empty numerators table";
        return res;
    }
    
    public static ArrayList<Integer> decodePowers(String str) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        String[] tab = str.split(":");
        for (int x=0; x<tab.length; x++) {
            res.add(Integer.valueOf(tab[x]));
        }
        assert res.size() > 0 : "empty denominators table";
        return res;
    }
    
    public static ArrayList<Character> decodeOperators(String str) {
        ArrayList<Character> res = new ArrayList<Character>();
        String[] tab = str.split(":");
        for (int x=0; x<tab.length; x++) {
            res.add(tab[x].charAt(0));
        }
        assert res.size() > 0 : "empty operators table";
        return res;
    }
	
	/**
	 * Decode the string generate by the encode() method of this class
	 * @param str encoded question
	 * @return decoded question (object)
	 */
	public static QuestionFraction decode(String str) {
		QuestionFraction res = null;
		if (str.substring(0,17).compareTo("#QuestionFraction") == 0) {
			res = new QuestionFraction();
			int i = 17;
			if (str.charAt(i) == '<') {
				while (str.charAt(i) != '>') {
					i++;
				}
				ArrayList<Integer> tmp_num = decodeOperands(str.substring(18,i));
				res.setNumerators(tmp_num);
				
				i++;
				int beginning = i;
				if (str.charAt(i) == '<') {
					while (str.charAt(i) != '>') {
						i++;
					}
					ArrayList<Integer> tmp_dnm = decodePowers(str.substring(beginning+1,i));
					res.setDenominators(tmp_dnm);
				
					i++;
					beginning = i;
					if (str.charAt(i) == '<') {
						while (str.charAt(i) != '>') {
							i++;
						}
						ArrayList<Character> tmp_opt = decodeOperators(str.substring(beginning+1,i));
						assert tmp_opt.size() == tmp_opt.size()+1 : "incorrect size of operators table";
						res.setOperators(tmp_opt);
						
						i++;
						beginning = i;
						if (str.charAt(i) == '<') {
							while (str.charAt(i) != '>') {
								i++;
							}
							int tmp_lth = Integer.valueOf(str.substring(beginning+1,i));
							assert tmp_lth < 0 : "negative length";
							res.setLength(tmp_lth);
							
							i++;
							str = str.substring(i);
							Question.decode(res, str);
						} else {
							res = null;
						}
					} else {
						res = null;
					}
				} else {
					res = null;
				}
			} else {
				res =null;
			}
		}
		return res;
	}
    
}
