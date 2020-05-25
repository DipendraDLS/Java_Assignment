/*
   Q) Write a program to illustrate the process of executing SQL statements in JDBC? [2073, 2074]

   Q) Implement CRUD (Create/Insert, Read/Select, Update, Delete) operations for student table.
      Ask for user input where applicable.
 */

package Q02_Q03_SQLStatements;

import java.sql.*;
import java.util.Scanner;

public class Create {
    public static void main(String[] args) throws SQLException {
//********************************************* Establishing Connection to the Database ************************************************

        String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);

//************************************  Insert into students table according to user input ****************************************************************************
        Statement statement= connection.createStatement();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = in.nextLine();
        System.out.println("Enter District:");
        String district = in.next();
        System.out.println("Enter Age:");
        int age = in.nextInt();

        String sql = String.format("Insert into students (name,district,age) Values ('"+name+"','"+district+"','"+age+"')");
        int rowInserted = statement.executeUpdate(sql);
        if(rowInserted>0)
            System.out.println("Row Inserted Successfully!");
        else
            System.out.println("Row Insertion Failed!!");
        statement.close();
        connection.close();
    }
}
