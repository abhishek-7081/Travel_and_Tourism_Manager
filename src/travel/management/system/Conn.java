///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package travel.management.system;
//
//import java.sql.*;  
//
//public class Conn{
//    Connection c;
//    Statement s;
//    public Conn(){  
//        try{  
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
////            Class.forName("com.mysql.jdbc.Driver");  
//            c =DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","1234"); 
//            
//            s =c.createStatement();  
//            
//           
//        }catch(Exception e){ 
//            System.out.println(e);
//        }  
//    }  
//}  


package travel.management.system;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;

    public Conn(){  
        try{  
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem?useSSL=false&autoReconnect=true", "root", "1234"); 
            
            // Create the statement
            s = c.createStatement();  
            
            
                 // Check if connection is successful
            if (c != null) {
                System.out.println("Connection established successfully!");
            }
        } catch(Exception e){ 
            // Print the error to the console
            System.out.println(e);
        }  
    }  
}
