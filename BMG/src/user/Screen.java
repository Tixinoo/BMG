/*
NOTES IMPORTANTES : [OK = test verifie ; ... = en cours ; / = non implementee]
insert : ...
update : ...
delete : ...
findById : ...
findByNom : /
*/

package user;

public class Screen 
{
    private int id_s;
    private String name_s;
    
    /* CONSTRUCTOR */
    public Screen() {}
    
    /* GETTERS & SETTERS */
    public int getId_s()
    {
	return id_s;
    }

    public void setId_s(int id_s) 
    {
	this.id_s = id_s;
    }

    public String getName_s() 
    {
	return name_s;
    }

    public void setName_s(String name_s) 
    {
	this.name_s = name_s;
    }

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
}
