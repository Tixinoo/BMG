package tests;

import database.BaseSetting;
import model.Exercise;
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
	
	User user_1 = new User(userType_5.getId_ut(),"Prenom1","Nom1","Ecole1","Email1","MdP1");
	b = user_1.insert(bs);
	System.out.println(""+b+" insertion user 1");
	User user_2 = new User(userType_4.getId_ut(),"Prenom2","Nom2","Ecole2","Email2","MdP2");
	b = user_2.insert(bs);
	System.out.println(""+b+" insertion user 2");
	
	User u;
	u = User.findById(user_2.getId_u(),bs);
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("insert U : pas OK");
	
	u.setFname_u("...");
	u.update(bs);
	
	if (u != null) System.out.println(""+u.getId_u()+" | "+u.getFname_u()+""); else System.out.println("update U : pas OK");
	
	u.delete(bs);
	u = User.findById(user_2.getId_u(),bs);
	
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
	
//	Exercise exercise_1 = new Exercise("Exercise1");
//	b = exercise_1.insert(bs);
//	System.out.println(""+b+" insertion exercise_1");
//	Exercise exercise_2 = new Exercise("Exercise2");
//	b = exercise_2.insert(bs);
//	System.out.println(""+b+" insertion exercise_1");
//	Exercise exercise_3 = new Exercise("Exercise3");
//	b = exercise_3.insert(bs);
//	System.out.println(""+b+" insertion exercise_1");
//	
//	Exercise e;
//	e = Exercise.findById(exercise_3.getId_e(),bs);
//	
//	if (e != null) System.out.println(""+e.getId_e()+" | "+e.getTitle_e()+""); else System.out.println("insert E : pas OK");
//	
//	e.setTitle_e("...");
//	e.update(bs);
//	
//	if (e != null) System.out.println(""+e.getId_e()+" | "+e.getTitle_e()+""); else System.out.println("update E : pas OK");
//	
//	e.delete(bs);
//	e = Exercise.findById(exercise_3.getId_e(),bs);
//	
//	if (e != null) System.out.println(""+e.getId_e()+" | "+e.getTitle_e()+""); else System.out.println("delete E : OK");
	
//	QuestionCalculation questionCalculation_1 = new QuestionCalculation("Questioncalculation1");
//	b = questionCalculation_1.insert(bs);
//	System.out.println(""+b+" insertion questionCalculation_1");
//	QuestionCalculation questionCalculation_2 = new QuestionCalculation("QuestionCalculation2");
//	b = questionCalculation_2.insert(bs);
//	System.out.println(""+b+" insertion questionCalculation_2");
//	QuestionCalculation questionCalculation_3 = new QuestionCalculation("QuestionCalculation3");
//	b = questionCalculation_3.insert(bs);
//	System.out.println(""+b+" insertion questionCalculation_1");
//	
//	QuestionCalculation qc;
//	qc = QuestionCalculation.findById(questionCalculation_3.getId_qc(),bs);
//	
//	if (qc != null) System.out.println(""+qc.getId_qc()+" | "+qc.getText_qc()+""); else System.out.println("insert QC : pas OK");
//	
//	qc.setTitle_qc("...");
//	qc.update(bs);
//	
//	if (qc != null) System.out.println(""+qc.getId_qc()+" | "+qc.getText_qc()+""); else System.out.println("update QC : pas OK");
//	
//	qc.delete(bs);
//	qc = QuestionCalculation.findById(questionCalculation_3.getId_qc(),bs);
//	
//	if (qc != null) System.out.println(""+qc.getId_qc()+" | "+qc.getText_qc()+""); else System.out.println("delete QC : OK");
    }
}
