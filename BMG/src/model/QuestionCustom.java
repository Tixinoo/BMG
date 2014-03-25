package model;

import database.BaseSetting;
import exceptions.DecodeException;
import exceptions.EncodeException;
import java.util.ArrayList;

public class QuestionCustom<SolutionType> extends Question {

    // ----- ATTRIBUTE -----
    
    // Inherited

    /**
     * Solution of the question.
     */
    private SolutionType[] solution;

    // ----------------------
    
    // ---- CONSTRUCTORS ----
    
    /**
     * This constructor creates an empty question.
     */
    public QuestionCustom() {
        super();
        this.text = "Answer.";
        this.difficulty = 0;
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
        this.solution = null;
    }
    
    /**
     * This constructor creates a question,
     * with the text and the solution given in parameters.
     */
    public QuestionCustom(String QCtext, SolutionType[] QCsolution) {
        super();
        if (QCtext != null) {
            this.text = QCtext;
        } else {
            this.text = "...";
        }
        this.difficulty = 0;
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
        this.solution = null;
    }
    
    /**
     * This constructor creates a question,
     * with the text, the difficulty and the solution given in parameters.
     */
    public QuestionCustom(String QCtext, int QCdifficulty, SolutionType[] QCsolution) {
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
        this.solution = QCsolution;
    }
    
    

    // ----------------------
    
    // ------- METHODS ------
    
    // Inherited

    public void setSolution(SolutionType[] solution) {
        this.solution = solution;
    }
    
    public String encodeSolution() throws EncodeException {
        StringBuilder res = new StringBuilder();
        if (this.solution != null && this.solution.length > 0) {
            if (solution[0] instanceof Integer) {
                res.append("int");
            } else if (solution[0] instanceof Double) {
                res.append("dbl");
            } else if (solution[0] instanceof Character) {
                res.append("chr");
            } else if (solution[0] instanceof String) {
                res.append("str");
            } else if (solution[0] instanceof Boolean) {
                res.append("bln");
            } else {
                throw new EncodeException("Unsupported variable type");
            }
            res.append("><");
            for (Object value : this.solution) {
                res.append(value).append(':');
            }
            res.replace(res.length()-1, res.length(), "");
        } else {
            throw new EncodeException("Empty solution array");
        }
        return res.toString();
    }
    
    public static Class decodeSolutionType(String encodedQuestion) throws DecodeException, ClassNotFoundException {
        Class res;
        int i=0;
        int beginning = i;
        while (encodedQuestion.charAt(i) != '>') {
            i++;
        }
        String type = encodedQuestion.substring(beginning, i);
        
        switch(type) {
            case "int":
                res = Class.forName("Integer");
                break;
            case "dbl":
                res = Class.forName("Double");
                break;
            case "str":
                res = Class.forName("String");
                break;
            case "chr":
                res = Class.forName("Character");
                break;
            default:
                throw new DecodeException("non recognized type");
        }
        return res;
    }
    
    public SolutionType[] decodeSolution(String str) throws DecodeException {
        SolutionType[] res;
        int i=0;
        int beginning = i;
        while (str.charAt(i) != '>') {
            i++;
        }
        String type = str.substring(beginning, i);
        
        i++;
        beginning = i;
        if (str.charAt(i) == '<') {
            i++;
            while (i < str.length()) {
                i++;
            }
            String[] tab = str.substring(beginning+1, i).split(":");
            res = (SolutionType[]) new Object[tab.length];
            for (int x=0; x<tab.length; x++) {
                switch(type) {
                case "int":
                    res[x] = (SolutionType) Integer.valueOf(tab[x]);
                    break;
                case "dbl":
                    res[x] = (SolutionType) Double.valueOf(tab[x]);
                    break;
                case "str":
                    res[x] = (SolutionType) tab[x];
                    break;
                case "chr":
                    res[x] = (SolutionType) ((Character) tab[x].charAt(0));
                    break;
                default:
                    throw new DecodeException("non recognized type");
                }
            }
        } else {
            res = null;
            throw new DecodeException();
        }
        return res;
    }
    
    @Override
    public String encode() throws EncodeException {
        StringBuilder res = new StringBuilder("#QuestionCustom<");
        res.append(encodeSolution());
        res.append(">");
        res.append(super.encode());
        return res.toString();
    }
    
    public static QuestionCustom decode(String str) throws DecodeException, ClassNotFoundException {
        if (str.substring(0, 15).compareTo("#QuestionCustom") == 0) {
            int i = 15;
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    i++;
                }
                Class objectType = decodeSolutionType(str.substring(16, i));
                if (objectType == Class.forName("Integer")) {
                    QuestionCustom<Integer> res = new QuestionCustom<>();
                    i++;
                    int beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setSolution(res.decodeSolution(str.substring(beginning+1, i)));
                        
                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                        return res;
                    } else {
                        throw new DecodeException();
                    }
                } else if (objectType == Class.forName("Double")) {
                    QuestionCustom<Double> res = new QuestionCustom<>();
                    i++;
                    int beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setSolution(res.decodeSolution(str.substring(beginning+1, i)));
                        
                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                        return res;
                    } else {
                        throw new DecodeException();
                    }
                } else if (objectType == Class.forName("String")) {
                    QuestionCustom<String> res = new QuestionCustom<>();
                    i++;
                    int beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setSolution(res.decodeSolution(str.substring(beginning+1, i)));
                        
                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                        return res;
                    } else {
                        throw new DecodeException();
                    }
                } else if (objectType == Class.forName("Character")) {
                    QuestionCustom<Character> res = new QuestionCustom<>();
                    i++;
                    int beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setSolution(res.decodeSolution(str.substring(beginning+1, i)));
                        
                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                        return res;
                    } else {
                        throw new DecodeException();
                    }
                } else if (objectType == Class.forName("Boolean")) {
                    QuestionCustom<Boolean> res = new QuestionCustom<>();
                    i++;
                    int beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setSolution(res.decodeSolution(str.substring(beginning+1, i)));
                        
                        i++;
                        str = str.substring(i);
                        Question.decode(res, str);
                        return res;
                    } else {
                        throw new DecodeException();
                    }
                } else {
                    throw new DecodeException("unsupported type");
                }
            } else {
                throw new DecodeException();
            }
        } else {
            throw new DecodeException();
        }
    }
    
    public SolutionType[] solve() {
        return solution;
    }
    
    /**
     * Display a question custom.
     */
    @Override
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

    @Override
    public ArrayList<Question> findAll_ByIdExercise(int ide, BaseSetting bs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
