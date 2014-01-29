/*
NOTES IMPORTANTES : [OK = test verifie ; ... = en cours ; / = non implementee]
insert : ...
update : ...
delete : ...
findById : ...
findByNom : /
*/

package user;

public class Workgroup 
{
    private int id_wg;
    private String name_wg;
    
    /* CONSTRUCTOR */
    public Workgroup() {}
    
    /* GETTERS & SETTERS */
    public int getId_wg() 
    {
	return id_wg;
    }

    public void setId_wg(int id_wg) 
    {
	this.id_wg = id_wg;
    }

    public String getName_wg() 
    {
	return name_wg;
    }

    public void setName_wg(String name_wg) 
    {
	this.name_wg = name_wg;
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
