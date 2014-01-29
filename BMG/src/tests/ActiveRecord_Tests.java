package tests;

import user.User;
import user.UserType;

public class ActiveRecord_Tests 
{
    @SuppressWarnings("null")
    public static void main(String[] args)
    {
	String s = "";
	
	UserType userType_1 = new UserType("Groupe1");
	s = userType_1.insert();
	System.out.println(""+s+" insertion userType 1");
	UserType userType_2 = new UserType("Groupe2");
	s = userType_2.insert();
	System.out.println(""+s+" insertion userType 2");
	UserType userType_3 = new UserType("Groupe3");
	s = userType_3.insert();
	System.out.println(""+s+" insertion userType 3");
	UserType userType_4 = new UserType("Groupe4");
	s = userType_4.insert();
	System.out.println(""+s+" insertion userType 4");
	UserType userType_5 = new UserType("Groupe5");
	s = userType_5.insert();
	System.out.println(""+s+" insertion userType 5");
	UserType userType_6 = new UserType("Groupe6");
	s = userType_6.insert();
	System.out.println(""+s+" insertion userType 6");
	
	User user = new User(userType_5.getId_ut(),"Antoine","NONO","IUT Charlo","kikoolol57@hotmail.fr","comme_MA_b***");
	s = user.insert();
	System.out.println(""+s+" insertion user");
	
	User u;
	u = User.findById(user.getId_u());
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("lol");
	
	u.setFname_u("...");
	u.update();
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("lol");
	
	u.delete();
	u = User.findById(user.getId_u());
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("lol");
    }
}
