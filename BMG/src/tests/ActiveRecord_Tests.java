package tests;

import user.Screen;
import user.User;
import user.UserType;
import user.Workgroup;

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
	s = user.insert(bs);
	System.out.println(""+s+" insertion user");
	
	User u;
	u = User.findById(user.getId_u(),bs);
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("insert U : pas OK");
	
	u.setFname_u("...");
	u.update(bs);
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("update U : pas OK");
	
	u.delete(bs);
	u = User.findById(user.getId_u(),bs);
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("delete U : OK");
	
	UserType ut;
	ut = UserType.findById(userType_6.getId_ut());
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("insert UT : pas OK");
	
	ut.setName_ut("...");
	ut.update();
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("update UT : pas OK");
	
	ut.delete();
	ut = UserType.findById(userType_6.getId_ut());
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("delete UT : OK");
	
	Screen screen_1 = new Screen("Ecran1");
	s = screen_1.insert();
	System.out.println(""+s+" insertion screen 1");
	Screen screen_2 = new Screen("Ecran2");
	s = screen_2.insert();
	System.out.println(""+s+" insertion screen 2");
	Screen screen_3 = new Screen("Ecran3");
	s = screen_3.insert();
	System.out.println(""+s+" insertion screen 3");
	
	Screen sc;
	sc = Screen.findById(screen_3.getId_s());
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("insert S : pas OK");
	
	sc.setName_s("...");
	sc.update();
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("update S : pas OK");
	
	sc.delete();
	sc = Screen.findById(screen_3.getId_s());
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("delete S : OK");
	
	Workgroup workGroup_1 = new Workgroup("GroupeDeTravail1");
	s = workGroup_1.insert();
	System.out.println(""+s+" insertion workGroup 1");
	Workgroup workGroup_2 = new Workgroup("GroupeDeTravail2");
	s = workGroup_2.insert();
	System.out.println(""+s+" insertion workGroup 2");
	
	Workgroup wg;
	wg = Workgroup.findById(workGroup_2.getId_wg());
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("insert WG : pas OK");
	
	wg.setName_wg("...");
	wg.update();
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("update WG : pas OK");
	
	wg.delete();
	wg = Workgroup.findById(workGroup_2.getId_wg());
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("delete WG : OK");
    }
}
