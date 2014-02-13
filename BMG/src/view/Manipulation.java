/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.BaseSetting;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blaise
 */
public class Manipulation {
    //Class just with static method.
    
    private String label = "Not Connected yet";

    public Manipulation() {

    }

   /* public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }*/
    
    

    public static String[] getAllSchoolName(BaseSetting bs) {
        
        
//        if (bs == null) {
//            System.out.println("school - BS NULL");
//        } else {
//              
//            ArrayList<String> list = new ArrayList<String>();
//            try {
//                //
//                String query = "SELECT * from School";
//                bs.setStatement(bs.getConnection().createStatement());
//                bs.setResult_set(bs.getStatement().executeQuery(query));
//
//                while (bs.getResult_set().next()) {
//                    list.add(bs.getResult_set().getString("name"));
//                }
//                String res[] = new String[list.size()];
//
//                for (int i = 0; i < list.size(); i++) {
//                    res[i] = list.get(i);
//                }
//
//                return res;
//            } catch (SQLException ex) {
//                Logger.getLogger(Manipulation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

        return null;
    }
}
