/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Semenenko
 */
public class DB {
    public static Connection connect;
    public static ResultSet rs;
    public static Statement st;
    
    public static void ConnectDB() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:Hospital.sqlite");
        st = connect.createStatement();
    }
}
