/*
    Q) Implement CRUD operations for student table using prepared statements.
       Ask for user input where applicable.
 */
package Q04_CrudPreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class DeletePreparedStatement
{
    public static void main(String[] args) throws SQLException
    {
//********************************************* Establishing Connection to the Database ************************************************

        String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
        String username = "root";    //For connection we need 'username' and 'password'
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);


// **************** If user want to select but he/she don't know what values are  inside database table ***********************************

        System.out.println("Do You want to see database table before making Selection Query??(Y/N):");
        Scanner in = new Scanner(System.in);
        char userChoice = in.next().charAt(0);

        if (userChoice == 'Y') {
            String sql = "select * from students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d, %s, %s, %s, \n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("district"),
                        resultSet.getString("age")
                );
            }

        }

// **************** If user want to select but he/she don't know what values are  inside database table ***********************************
        if (userChoice == 'N')
        {
            //********************* Taking input from user*********************
            System.out.println("Enter the Id to Delete from database:");
            int id = in.nextInt();

            // ************* Sql prepared statement *************************
            String sql = "delete from students where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            //************* Binding Parameters ***************************
            statement.setInt(1, id);

            int rowDeleted = statement.executeUpdate();

            //******************** message for user if rows are  successfully deleted or not ******
            if (rowDeleted > 0)
                System.out.println("Row Deleted Successfully!!");

            else
                System.out.println("Row isn't Deleted!!");

            statement.close();
            connection.close();
        }
    }
}

