package model;

import database.BaseSetting;
import java.util.*;

public class QuestionEquation extends Question {

    // ----- ATTRIBUTES -----
    // Inherited
    /**
     * Operands of the equation (without unknowns)
     */
    private ArrayList<Integer> operands;

    /**
     * Placements of the unknowns in the equation
     */
    private ArrayList<Boolean> unknowns;

    /**
     * Operators of the equation ('=' included)
     */
    private ArrayList<Character> operators;

    /**
     * Length of the equation
     */
    private int length;

    // ----------------------
    // ---- CONSTRUCTORS ----
    /**
     * This constructor creates the simplest question for a calculation
     */
    public QuestionEquation() {
        super();
        this.text = "Solve.";
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.unknowns = new ArrayList<Boolean>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    /**
     * This constructor creates a question with the text given in parameter
     */
    public QuestionEquation(String QCtext) {
        super();
        this.text = QCtext;
        this.difficulty = 0;
        this.operands = new ArrayList<Integer>();
        this.unknowns = new ArrayList<Boolean>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    /**
     * This constructor creates a question with the text and the difficulty given in parameters
     */
    public QuestionEquation(String QCtext, int QCdifficulty) {
        super();
        this.text = QCtext;
        this.difficulty = QCdifficulty;
        this.operands = new ArrayList<Integer>();
        this.unknowns = new ArrayList<Boolean>();
        this.operators = new ArrayList<Character>();
        this.length = 0;
    }

    // ----------------------
    // ------- METHODS ------
    // Inherited
    /**
     * Generate a random question with an equation
     */
    public void generate() {
        char[] possible_operators = {'+', '-', '*', '/'};
        this.length = (int) (Math.random() * 10) + 2;
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                if (i < this.length - 2) {
                    this.unknowns.add(Math.random() < 0.3);
                    this.operators.add(possible_operators[(int) (Math.random() * 4)]);
                } else {
                    this.unknowns.add(true);
                    this.operators.add('=');
                }
            }
        }
    }

    /**
     * Generate a random question with an equation with the length given in parameter
     */
    public void generate(int QClength) {
        char[] possible_operators = {'+', '-', '*', '/'};
        this.length = 2;
        if (QClength > 2) {
            this.length = QClength;
        }
        System.out.println("	Random length: " + this.length);
        for (int i = 0; i < this.length; i++) {
            this.operands.add((int) (Math.random() * 20) + 1);
            if (i < this.length - 1) {
                if (i < this.length - 2) {
                    this.unknowns.add(Math.random() < 0.3);
                    this.operators.add(possible_operators[(int) (Math.random() * 4)]);
                } else {
                    this.unknowns.add(true);
                    this.operators.add('=');
                }
            }
        }
    }

    /**
     * Solve a question with an equation
     */
    public double solve() {
        double res = 0;
        return res;
    }

    /**
     * Display a question with an equation
     */
    public String toString() {
        String res = "      QuestionEquation";
        res = res + "\n         Text: " + this.text;
        res = res + "\n         Difficulty: " + this.difficulty;
        res = res + "\n         Operands: " + this.operands;
        res = res + "\n         Operators: " + this.operators;
        res = res + "\n         Unknowns: " + this.unknowns;
        res = res + "\n         Length: " + this.length;
        Iterator<Integer> it_operands = this.operands.iterator();
        Iterator<Character> it_operators = this.operators.iterator();
        Iterator<Boolean> it_unknowns = this.unknowns.iterator();
        res = res + it_operands.next();
        while (it_operands.hasNext()) {
            res = res + it_operators.next();
            if (it_unknowns.next()) {
                res = res + "x";
            }
            res = res + it_operands.next();
        }
        return res;
    }

    public ArrayList<Integer> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }

    public ArrayList<Boolean> getUnknowns() {
        return unknowns;
    }

    public void setUnknowns(ArrayList<Boolean> unknowns) {
        this.unknowns = unknowns;
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
        Iterator<Integer> itopd = operands.iterator();
        while (itopd.hasNext()) {
            res = res + itopd.next() + ":";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public String encodeUnknowns() {
        String res = new String();
        Iterator<Boolean> itukn = unknowns.iterator();
        while (itukn.hasNext()) {
            res = res + itukn.next() + ":";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public String encodeOperators() {
        String res = new String();
        Iterator<Character> itopt = operators.iterator();
        while (itopt.hasNext()) {
            res = res + itopt.next() + ":";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    /**
     * Encode the current question (object) in a string which can recreate this question by the decode() method
     *
     * @return encoded question
     */
    public String encode() {
        String res = "#QuestionEquation<";
        res = res + encodeOperands();
        res = res + "><";
        res = res + encodeUnknowns();
        res = res + "><";
        res = res + encodeOperators();
        res = res + "><" + length + ">";
        res = res + super.encode();
        return res;
    }

    /**
     * Decode the string generate by the encode() method of this class
     *
     * @param str encoded question
     * @return decoded question (object)
     */
    public static QuestionEquation decode(String str) {
        QuestionEquation res = null;
        if (str.substring(0, 17).compareTo("#QuestionEquation") == 0) {
            res = new QuestionEquation();
            int i = 17;
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    i++;
                }
                String[] tab = str.substring(18, i).split(":");
                ArrayList<Integer> tmp_opd = new ArrayList<Integer>();
                for (int x = 0; x < tab.length; x++) {
                    tmp_opd.add(Integer.valueOf(tab[x]));
                }
                assert tmp_opd.size() > 0 : "empty operands table";
                res.setOperands(tmp_opd);

                i++;
                int beginning = i;
                if (str.charAt(i) == '<') {
                    while (str.charAt(i) != '>') {
                        i++;
                    }
                    tab = str.substring(beginning + 1, i).split(":");
                    ArrayList<Boolean> tmp_ukn = new ArrayList<Boolean>();
                    for (int x = 0; x < tab.length; x++) {
                        tmp_ukn.add(Boolean.valueOf(tab[x]));
                    }
                    assert tmp_ukn.size() > 0 : "empty unknowns table";
                    res.setUnknowns(tmp_ukn);

                    i++;
                    beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        tab = str.substring(beginning + 1, i).split(":");
                        ArrayList<Character> tmp_opt = new ArrayList<Character>();
                        for (int x = 0; x < tab.length; x++) {
                            tmp_opt.add(tab[x].charAt(0));
                        }
                        assert tmp_opt.size() > 0 : "empty operators table";
                        assert tmp_opt.size() == tmp_opt.size() + 1 : "incorrect size of operators table";
                        res.setOperators(tmp_opt);

                        i++;
                        beginning = i;
                        if (str.charAt(i) == '<') {
                            while (str.charAt(i) != '>') {
                                i++;
                            }
                            int tmp_lth = Integer.valueOf(str.substring(beginning + 1, i));
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
                res = null;
            }
        }
        return res;
    }

    // ----------------------
    // ----- DB METHODS -----

    /* MISE A JOURS */
    public boolean insert(BaseSetting bs) {
        return false;
    }

    public boolean update(BaseSetting bs) {
        return false;
    }

    public boolean delete(BaseSetting bs) {
        return false;
    }

    /* FINDERS */
    public static QuestionEquation findById(int id, BaseSetting bs) {
        return null;
    }

    // ----------------------
}
