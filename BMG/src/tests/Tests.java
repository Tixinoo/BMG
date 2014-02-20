package tests;

import database.BaseSetting;
import user.School;

public class Tests 
{

    public static void main(String[] args)
    {
        try 
        {
            BaseSetting bs = new BaseSetting();
            
            String[] tab;
            
            School.addSchoolName(bs,"ECOLE 1");
            School.addSchoolName(bs,"ECOLE 2");
            School.addSchoolName(bs,"ECOLE 3");
            tab = School.getAllSchoolName(bs);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
    }
    
}
