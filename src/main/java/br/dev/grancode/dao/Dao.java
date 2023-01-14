package br.dev.grancode.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "leo", "root");
        }catch(Exception e){System.out.println(e.getMessage());}
        return con;
    }
}
