/*
    Q) Implement CRUD operations for student table using prepared statements.
       Ask for user input where applicable.
 */
package Q04_CrudPreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class CreatePreparedStatement {
    public static void main(String[] args) throws SQLException {
//********************************************* Establishing Connection to the Database ************************************************

        String url = "jdbc:mariadb://localhost:3306/JavaJDBC?";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);

//************************************  Insert into students table according to user input ****************************************************************************
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Name:");
        String name = in.next();

        System.out.println("Enter District:");
        String district = in.next();

        System.out.println("Enter Age:");
        int age = in.nextInt();

        //************************** Sql prepared statement *****************************************
        String sql = String.format("Insert into students (name,district,age) Values (?,?,?)");

        PreparedStatement statement = connection.prepareStatement(sql);

        //****************** Binding Parameter ******************************************************
        statement.setString(1,name);
        statement.setString(2,district);
        statement.setInt(3,age);
        int rowInserted = statement.executeUpdate();

        //******************** message for user if rows are  successfully updated or not **********
        if(rowInserted>0)
            System.out.println("Row Inserted Successfully!");
        else
            System.out.println("Row Insertion Failed!!");
        statement.close();
        connection.close();
    }
}
