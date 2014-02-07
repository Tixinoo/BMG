import database.BaseInformation;
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
        new BmgFrame("BMG 2014", 1200, 800);
    }
}
