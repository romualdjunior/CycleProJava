/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author toshiba
 */
public class DataSource {
    public static DataSource instance;
    private final String URL="jdbc:mysql://localhost:3322/cyclepro";
    private final String LOGIN="root";
    private final String PWD="";
    private Connection cnx;
    private  DataSource(){
        try {
            cnx=DriverManager.getConnection(URL, LOGIN, PWD);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    public static DataSource getInstance(){
        if (instance==null) {
                    instance = new DataSource();
        }
        return instance;
        
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}
