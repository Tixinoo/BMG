
import database.BaseInformation;
import database.BaseSetting;
import view.BmgFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author blaise
 */
public class Principale {

    public static void main(String[] args) {
        //new BaseInformation("mysql", "com.mysql.jdbc.Driver", "BMG_DB", "root", "", "//localhost");
        if (args.length == 1) {
            switch (args[0]) {
                case "-test":
                    testerConnection();
                    break;
            }
        } else {
            BmgFrame bmgFrame = new BmgFrame("BMG 2014", 1200, 800);
        }
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
