package org.example;

import java.sql.*;

public class DbConnection {
    public static void main(String[] args)  {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con= DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/test-one","root","manuk2000");
           Statement stmt=con.createStatement();
           ResultSet rs=stmt.executeQuery("select * from table1");
           while(rs.next())
               System.out.println(rs.getString(1));
           con.close();
       }catch (Exception e){System.out.println(e);}

    }
}
