package model;

import database.BaseSetting;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     * Exercise's difficulty '0' corresponds to an unknown difficulty '1' corresponds to the easiest difficulty
     */
    private int difficulty;

    /**
     * True if the exercise is ready to be used, so if the exercise has (at least): - 1 statement (not null); - 1 question in the list of questions; - a type; - a difficulty;
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
     * This constructor creates an exercise of the type given in parameter All others characteristics are random
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
     * This constructor creates an exercise of the type and of a difficulty given in parameters
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
     * Generate a random exercise with 10 randoms questions, type must be precised in the attribute.
     */
    public void generate() {
        if (this.type != "") {
            switch (type) {
                case "calculation":
                    for (int i = 0; i < 10; i++) {
                        QuestionCalculation qc = new QuestionCalculation();
                        qc.generate();
                        this.addQuestion(qc);
                    }
                    break;
                case "fraction":
                    for (int i = 0; i < 10; i++) {
                        QuestionFraction qf = new QuestionFraction();
                        qf.generate();
                        this.addQuestion(qf);
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
    public void setWording(Wording Ewording) {
        if (Ewording != null) {
            this.wording = Ewording;
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

    public void setTitle(String Etitle) {
        this.title = Etitle;
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
     *
     */
    public void setID(int Eid) {
        if (Eid > 0) {
            this.id = Eid;
        } else {
            this.id = 0;
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

    public String encode() {
        String res = null;
        this.update_ready();
        System.out.println(this.isReady());
        if (this.isReady()) {
            System.out.println("HEHEHE");
            res = "<" + id + "><" + title + "><" + type + "><" + difficulty + ">\n";
            res = res + wording.encode() + "\n";
            Iterator<Question> itq = questions.iterator();
            while (itq.hasNext()) {
                res = res + itq.next().encode() + "\n";
            }
        }
        return res;
    }

    public static Exercise decode(String str) {
        Exercise res = null;
        if (str.charAt(0) == '<') {
            res = new Exercise();
            int i = 1;
            while (str.charAt(i) != '>') {
                i++;
            }
            res.setID(Integer.valueOf(str.substring(1, i)));

            i++;
            int beginning = i;
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    i++;
                }
                res.setTitle(str.substring(beginning + 1, i));

                i++;
                beginning = i;
                if (str.charAt(i) == '<') {
                    while (str.charAt(i) != '>') {
                        i++;
                    }
                    res.setType(str.substring(beginning + 1, i));

                    i++;
                    beginning = i;
                    if (str.charAt(i) == '<') {
                        while (str.charAt(i) != '>') {
                            i++;
                        }
                        res.setDifficulty(Integer.valueOf(str.substring(beginning + 1, i)));

                        i++;
                        str = str.substring(i);

                        i = 0;
                        beginning = 0;
                        while (str.length() != i) {
                            if (str.charAt(i) == '#') {
                                str = str.substring(i);
                                System.out.println(str);
                                i = 0;
                                while (str.charAt(i) != '<') {
                                    i++;
                                }
                                String qtype = str.substring(beginning, i);
                                switch (qtype) {
                                    case "#QuestionCalculaion":
                                        QuestionCalculation qc = QuestionCalculation.decode(str);
                                        System.out.println(qc);
                                        res.addQuestion(qc);
                                        break;
                                    case "#QuestionFraction":
                                        QuestionFraction qf = QuestionFraction.decode(str);
                                        System.out.println(qf);
                                        res.addQuestion(qf);
                                        break;
                                    case "#QuestionEquation":
                                        QuestionEquation qe = QuestionEquation.decode(str);
                                        System.out.println(qe);
                                        res.addQuestion(qe);
                                        break;
                                    case "#Wording":
                                        Wording w = Wording.decode(str);
                                        System.out.println(w);
                                        res.setWording(w);
                                        break;
                                }
                                i = 0;
                            }
                            i++;
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
        } else {
            res = null;
        }
        return res;
    }

    public void save() {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("ex" + id + ".bmg"));
            System.out.println("coucou;"+this.encode());
            file.write(this.encode());
            file.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("ERROR : file can not be found");
        } catch (IOException ioe) {
            System.out.println("ERREUR : in/out failure");
        }
    }

    public static Exercise load(String fname) {
        Exercise res = null;
        try {
            BufferedReader file = new BufferedReader(new FileReader(fname));
            res = Exercise.decode(file.toString());
            file.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("ERROR : file can not be found");
        } catch (IOException ioe) {
            System.out.println("ERREUR : in/out failure");
        }
        return res;
    }

    // ----------------------
    // ----- DB METHODS -----

    /* MISE A JOURS */
    public boolean insert(BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
//	try 
//	{
//	    String query = "INSERT INTO Exercise (id_w,title_e,type_e,diff_e,ready_e) VALUES (?,?,?,?,?)";
//	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
//	    p_statement.setInt(1,this.id_w);
//	    p_statement.setString(2,this.title);
//	    p_statement.setString(3,this.type);
//	    p_statement.setInt(4,this.difficulty);
//	    p_statement.setBoolean(5,this.ready);
//	    p_statement.executeUpdate();
//	    ResultSet rs = p_statement.getGeneratedKeys();
//	    
//	    if (rs.next()) this.id = rs.getInt(1);
//		    
//	}  
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return true;
    }

    public boolean update(BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
//	try 
//	{
//	    if (this.id < 0)
//	    {
//		String query = "UPDATE Exercise SET (id_w = ? , title_e = ? , type_e = ? , diff_e = ? , ready_e = ?) WHERE id_e = ?";
//		PreparedStatement p_statement = connection.prepareStatement(query);
//		p_statement.setInt(1,this.id);
//		p_statement.setString(2,this.title);
//		p_statement.setString(3,this.type);
//		p_statement.setInt(4,this.difficulty);
//		p_statement.setBoolean(5,this.ready);
//		p_statement.setInt(6,this.id);
//		p_statement.executeUpdate();
//	    }
//	}  
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return true;
    }

    public boolean delete(BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
//	try 
//	{
//	    if (Exercise.findById(this.getId(),bs) != null)
//	    {
//		String query = "DELETE FROM Exercise WHERE id_e = ?";
//		PreparedStatement p_statement = connection.prepareStatement(query);
//		p_statement.setInt(1,this.id);
//		p_statement.executeUpdate();
//	    }
//	}  
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return true;
    }

    /* FINDERS */
    public static Exercise findById(int id, BaseSetting bs) 
    {
        Connection connection = bs.getConnection();
	
	Exercise exercise = null;
	
//	try 
//	{
//	    String query = "SELECT * FROM Exercise WHERE id_e = ?";
//	    PreparedStatement p_statement = connection.prepareStatement(query);
//	    p_statement.setInt(1,id);
//	    
//	    ResultSet rs = p_statement.executeQuery();
//	    
//	    if (rs.next())
//	    {
//		int ide = rs.getInt("id_e");
//		int idw = rs.getInt("id_w");
//		String titlee = rs.getString("title_e");
//		String diffe = rs.getString("diff_e");
//		String readye = rs.getString("ready_e");
//	    
//		exercise = new Exercise(ide,idw,titlee,diffe,readye);
//	    }
//		    
//	}  
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return exercise;
    }

    // ----------------------
}
