package model;

import database.BaseSetting;
import interfaces.iDbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.User;


public class Wording implements iDbManager {

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
            for (int i = 0; i < this.values.length; i++) {
                res = res + this.values[i] + "  ";
            }
        }
        // res = res + "\n-----------------------";
        return res;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public Object[] getValues() {
		return values;
	}

    public String encode() {
		String res = "#Wording<" + id + "><$<" + text + ">$><";
		String type;
		if (values != null && values.length != 0) {
			if (values[0] instanceof Integer) {
				type = "int";
			} else if (values[0] instanceof Double) {
				type = "dbl";
			} else if (values[0] instanceof Character) {
				type = "chr";
			} else if (values[0] instanceof String) {
				type = "str";
			} else {
				type = "nul";
			}
		} else {
			type = "nul";
		}
		res = res + type + "><";
		for (int i = 0; i<values.length; i++) {
			res = res + values[i] + ":";
		}
		res = res.substring(0, res.length()-1);
		res = res + ">";
		return res;
	}
    
	public static Wording decode(String str) {
		Wording res = null;
        if (str.substring(0, 8).compareTo("#Wording") == 0) {
            res = new Wording();
            int i = 8;
            if (str.charAt(i) == '<') {
                while (str.charAt(i) != '>') {
                    i++;
                }
                assert i > 8 : "no id number";
                res.setId(Integer.valueOf(str.substring(9, i)));

                i += 3;
                int beginning = i;
                if (str.substring(i-2, i+1).compareTo("<$<") == 0) {
                    while (str.substring(i-2, i+1).compareTo(">$>") != 0) {
                        i++;
                    }
                    assert i > beginning+1 : "no wording text";
                    res.setText(str.substring(beginning+1, i-1));
                    
                    i++;
                    if ((str.charAt(i) == '<') && (str.charAt(i+4) == '>')) {
	                    String type = str.substring(i+1, i+4);
	                    i += 5;
                    	
	                    beginning = i;
	                    if (type.compareTo("nul") != 0) {
	                    	
		                    if (str.charAt(i) == '<') {
		                    	while (str.charAt(i) != '>') {
		                            i++;
		                        }
		                    	String[] tab = str.substring(beginning+1, i-1).split(":");
		                    	switch(type) {
		                    	case "int":
		                    		Integer[] val_int = new Integer[tab.length];
		                        	for (int x=0; x<tab.length; x++) {
		                        		val_int[x] = Integer.valueOf(tab[x]); 
		                        	}
		                        	res.values = val_int;
		                    		break;
		                    	case "dbl":
		                    		Double[] val_dbl = new Double[tab.length];
		                        	for (int x=0; x<tab.length; x++) {
		                        		val_dbl[x] = Double.valueOf(tab[x]);
		                        	}
		                        	res.setValues(val_dbl);
		                    		break;
		                    	case "str":
		                    		String[] val_str = tab;
		                    		res.setValues(val_str);
		                    		break;
		                    	case "chr":
		                    		Character[] val_chr = new Character[tab.length];
		                        	for (int x=0; x<tab.length; x++) {
		                        		val_chr[x] = tab[x].charAt(0); 
		                        	}
		                        	res.setValues(val_chr);
		                    		break;
		                    	}
		                    } else {
		                    	res = null;
		                    }
	                    } else {
	                    	res.setValues(null);
	                    }
	                    i++;
	                    str.substring(i);
                    } else {
                    	System.out.println("qmslkfdjmlkgjmldksfjmg");
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
    public boolean insert(BaseSetting bs) 
    {
	Connection connection = bs.getConnection();
	
//	try 
//	{
//	    String query = "INSERT INTO Wording (text_w,values_w) VALUE (?,?)";
//	    PreparedStatement p_statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
//	    p_statement.setString(1,""+this.text+"");
//	    p_statement.setString(2,""+this.values+"");
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
//		String query = "UPDATE Wording SET (text_w = ? , values_w = ?) WHERE id_w = ?";
//		PreparedStatement p_statement = connection.prepareStatement(query);
//		p_statement.setString(1,this.text);
//		p_statement.setString(2,this.values);
//		p_statement.setInt(3,this.id);
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
//	    if (Wording.findById(this.getId(),bs) != null)
//	    {
//		String query = "DELETE FROM Wording WHERE id_w = ?";
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
    public static Wording findById(int id, BaseSetting bs) 
    {
	Connection connection = bs.getConnection();
	
	Wording wording = null;
	
//	try 
//	{
//	    String query = "SELECT * FROM Wording WHERE id_w = ?";
//	    PreparedStatement p_statement = connection.prepareStatement(query);
//	    p_statement.setInt(1,id);
//	    
//	    ResultSet rs = p_statement.executeQuery();
//	    
//	    if (rs.next())
//	    {
//		int idw = rs.getInt("id_w");
//		String textw = rs.getString("text_w");
//		String valuesw = rs.getString("values_w");
//	    
//		wording = new Wording(idw,textw,valuesw);
//	    }
//		    
////	} 
//	catch (SQLException sqle) 
//	{
//	    System.out.println("ERREUR");
//	    sqle.printStackTrace();
//	}
	
	return wording;
    }

    // ----------------------
}
