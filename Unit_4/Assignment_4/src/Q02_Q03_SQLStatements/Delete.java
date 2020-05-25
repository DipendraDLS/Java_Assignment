/*
   Q) Write a program to illustrate the process of executing SQL statements in JDBC? [2073, 2074]

   Q) Implement CRUD (Create/Insert, Read/Select, Update, Delete) operations for student table.
      Ask for user input where applicable.

 */

package Q02_Q03_SQLStatements;

import java.sql.*;
import java.util.Scanner;

public class Delete
{

        public static void main(String[] args) throws SQLException
        {
//********************************************* Establishing Connection to the Database ************************************************

            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";    //For connection we need 'username' and 'password'
            String password= "";

            Connection connection = DriverManager.getConnection(url,username,password);

// ************************************ Creating SQL Statement ***************************************************************************
            Statement statement= connection.createStatement();

// **************** If user want to select but he/she don't know what values are  inside database table ***********************************

            System.out.println("Do You want to see database table before making Selection Query??(Y/N):");
            Scanner in = new Scanner(System.in);
            char userChoice = in.next().charAt(0);

            if (userChoice == 'Y')
            {
                String sql = "select * from students";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next())
                {
                    System.out.printf("%d, %s, %s, %s, \n",
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("district"),
                            resultSet.getString("age")
                    );
                }

            }
// **************** If user want to select but he/she don't know what values are  inside database table ***********************************
            if(userChoice== 'N')
            {
                //********************* Taking input from user*********************

                System.out.println("Enter the Id to Delete from database:");
                int id = in.nextInt();

                String sql = "delete from students where id= '" + id + "'";
                int rowDeleted = statement.executeUpdate(sql);

                //******************** message for user if rows are  successfully updated or not ******
                if (rowDeleted > 0)
                    System.out.println("Row Deleted Successfully!!");

                else
                    System.out.println("Row isn't Deleted!!");

                statement.close();
                connection.close();
            }
        }
}


