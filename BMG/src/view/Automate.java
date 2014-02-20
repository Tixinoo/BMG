package view;

import java.util.Scanner;
import database.BaseSetting;
import java.sql.SQLException;
import user.School;

public class Automate {

    public Automate(String[] args) {
        switch (args[0]) {
            case "-test":
                testerConnection();
                break;

            case "-adds":
                addSchool();
                break;
        }
    }

    public static void addSchool() {
        BaseSetting bs = new BaseSetting();
        if (bs.testerConnexion()) {
            //Ask name
            Scanner sc = new Scanner(System.in);
            System.out.println("School's name");
            String name = sc.nextLine();

            if (addSchoolWithName(bs, name)) {
                System.out.println(getColor(91) + "Add success !\n" + getColor(92) + "Run BMG Program now ? (Y/n)" + getColor(0));
                String again = sc.nextLine();

                if (again.equals("Y") || again.equals("y")) {
                    BmgFrame frame = new BmgFrame("BMG 2014", 800, 600);
                } else {

                }
            } else {
                System.out.println(getColor(91) + "Ohoh, error...  Try again ? (Y/n)" + getColor(0));
                String again = sc.nextLine();

                if (again.equals("Y") || again.equals("y")) {
                    addSchool();
                } else {

                }
            }

            //Add school
            sc.close();
        }
    }

    public static boolean addSchoolWithName(BaseSetting bs, String name) {
        
          //FIRST VERSION, WHITOUT OBJECT SCHOOL
        try {

            
            String query = "INSERT INTO School(name_sch) VALUES ('" + name + "')";

            bs.setStatement(bs.getConnection().createStatement());
            bs.getStatement().executeUpdate(query);

            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(PanelChercherMot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return false;
    }

    public static void testerConnection() {
        BaseSetting bs = new BaseSetting();
        if (bs.testerConnexion()) {
            System.out.println(getColor(41) + "Connection OK !" + getColor(0));
        } else {
            System.out.println(getColor(41) + "Error with database... !" + getColor(0));
        }
    }

    public static String getColor(int i) {
        return "\033[" + i + "m";
    }

}
