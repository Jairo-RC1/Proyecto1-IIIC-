/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.*;
import Model.DBConnectionJava;

public class Main {

    public static void main(String[] args) {
        Login lo = new Login();
        lo.setVisible(true);
        
        /*DBConnectionJava db = new DBConnectionJava();
        db.getConnection();
        db.disconnect();*/
    }
}
