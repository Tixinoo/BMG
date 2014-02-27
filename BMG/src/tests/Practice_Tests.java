package tests;

import database.BaseSetting;
import model.Exercise;
import model.Practice;
import user.User;
import user.UserType;

public class Practice_Tests 
{
    
    public static void main(String[] args)
    {   
        
        BaseSetting bs = new BaseSetting();
        
        Exercise e0 = new Exercise(); e0.insert(bs);
        Exercise e1 = new Exercise(); e1.insert(bs);
        Exercise e2 = new Exercise(); e2.insert(bs);
        
        UserType ut0 = new UserType("type");
        
        User u0 = new User(ut0.getId_ut(),"prenom0","nom0","ecole0","email0@email.com","password");
        User u1 = new User(ut0.getId_ut(),"prenom1","nom1","ecole1","email1@email.com","password");
        User u2 = new User(ut0.getId_ut(),"prenom2","nom2","ecole2","email2@email.com","password");
        
        Practice p0 = new Practice(u0.getId_u(),e1);
        Practice p1 = new Practice(u0.getId_u(),e2);
        Practice p2 = new Practice(u1.getId_u(),e1);
        Practice p3 = new Practice(u1.getId_u(),e2);
        Practice p4 = new Practice(u0.getId_u(),e1);
        Practice p5 = new Practice(u2.getId_u(),e0);
        Practice p6 = new Practice(u0.getId_u(),e0);
        Practice p7 = new Practice(u2.getId_u(),e0);
        Practice p8 = new Practice(u2.getId_u(),e1);
        Practice p9 = new Practice(u1.getId_u(),e0);
        
    }
    
}
