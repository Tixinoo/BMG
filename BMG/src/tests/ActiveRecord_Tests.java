package tests;

import database.BaseSetting;
import user.Screen;
import user.User;
import user.UserType;
import user.Workgroup;

public class ActiveRecord_Tests 
{
    @SuppressWarnings("null")
    public static void main(String[] args)
    {
	boolean b = true;
	
	BaseSetting bs = new BaseSetting();
	
	UserType userType_1 = new UserType("Groupe1");
	b = userType_1.insert(bs);
	System.out.println(""+b+" insertion userType 1");
	UserType userType_2 = new UserType("Groupe2");
	b = userType_2.insert(bs);
	System.out.println(""+b+" insertion userType 2");
	UserType userType_3 = new UserType("Groupe3");
	b = userType_3.insert(bs);
	System.out.println(""+b+" insertion userType 3");
	UserType userType_4 = new UserType("Groupe4");
	b = userType_4.insert(bs);
	System.out.println(""+b+" insertion userType 4");
	UserType userType_5 = new UserType("Groupe5");
	b = userType_5.insert(bs);
	System.out.println(""+b+" insertion userType 5");
	UserType userType_6 = new UserType("Groupe6");
	b = userType_6.insert(bs);
	System.out.println(""+b+" insertion userType 6");
	
	User user = new User(userType_5.getId_ut(),"Antoine","NONO","IUT Charlo","kikoolol57@hotmail.fr","comme_MA_b***");
	b = user.insert(bs);
	System.out.println(""+b+" insertion user");
	
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
	ut = UserType.findById(userType_6.getId_ut(),bs);
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("insert UT : pas OK");
	
	ut.setName_ut("...");
	ut.update(bs);
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("update UT : pas OK");
	
	ut.delete(bs);
	ut = UserType.findById(userType_6.getId_ut(),bs);
	
	if (ut != null) System.out.println(""+ut.getId_ut()+" | "+ut.getName_ut()+""); else System.out.println("delete UT : OK");
	
	Screen screen_1 = new Screen("Ecran1");
	b = screen_1.insert(bs);
	System.out.println(""+b+" insertion screen 1");
	Screen screen_2 = new Screen("Ecran2");
	b = screen_2.insert(bs);
	System.out.println(""+b+" insertion screen 2");
	Screen screen_3 = new Screen("Ecran3");
	b = screen_3.insert(bs);
	System.out.println(""+b+" insertion screen 3");
	
	Screen sc;
	sc = Screen.findById(screen_3.getId_s(),bs);
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("insert S : pas OK");
	
	sc.setName_s("...");
	sc.update(bs);
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("update S : pas OK");
	
	sc.delete(bs);
	sc = Screen.findById(screen_3.getId_s(),bs);
	
	if (sc != null) System.out.println(""+sc.getId_s()+" | "+sc.getName_s()+""); else System.out.println("delete S : OK");
	
	Workgroup workGroup_1 = new Workgroup("GroupeDeTravail1");
	b = workGroup_1.insert(bs);
	System.out.println(""+b+" insertion workGroup 1");
	Workgroup workGroup_2 = new Workgroup("GroupeDeTravail2");
	b = workGroup_2.insert(bs);
	System.out.println(""+b+" insertion workGroup 2");
	
	Workgroup wg;
	wg = Workgroup.findById(workGroup_2.getId_wg(),bs);
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("insert WG : pas OK");
	
	wg.setName_wg("...");
	wg.update(bs);
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("update WG : pas OK");
	
	wg.delete(bs);
	wg = Workgroup.findById(workGroup_2.getId_wg(),bs);
	
	if (wg != null) System.out.println(""+wg.getId_wg()+" | "+wg.getName_wg()+""); else System.out.println("delete WG : OK");
    }
}
