/*
    Q) Implement CRUD operations for student table using prepared statements.
       Ask for user input where applicable.
 */
package Q04_CrudPreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class UpdatePreparedStatement
{
    public static void main(String[] args) throws SQLException {
//********************************************* Establishing Connection to the Database ************************************************

        String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
        String username = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, username, password);

// **************** If user want to update but he/she don't know what values are  inside database table ***********************************

        System.out.println("Do You want to see database table before updating??(Y/N):");
        Scanner in = new Scanner(System.in);
        char userChoice = in.next().charAt(0);

        if (userChoice == 'Y')
        {
            String sql = "select * from students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf("%d, %s, %s, %s, \n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("district"),
                        resultSet.getString("age")
                );
            }
            statement.close();
        }
//******************* If user knows what to update in database table ****************************************************************************

        if (userChoice == 'N')
        {
            //************************ Taking User Input ********************************
            System.out.println("Enter the Id to update into database:");
            int id = in.nextInt();

            System.out.println("Enter the Name to update into database:");
            String name = in.next();

            System.out.println("Enter the District to update into database:");
            String district = in.next();

            System.out.println("Enter the Age to update into database:");
            int age = in.nextInt();

            //************************ Executing Sql statement **************************
            String sql = "update students set name = ?,district= ?, age = ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            //****************** Binding Parameter ******************************************************
            statement.setString(1,name);
            statement.setString(2,district);
            statement.setInt(3,age);
            statement.setInt(4,id);

            int rowUpdated = statement.executeUpdate();

            //******************** message for user if rows are  successfully updated or not **********
            if (rowUpdated > 0)
                System.out.println("Row updated Successfully!!");

            else
                System.out.println("Row isn't Updated!!");

            statement.close(); //statement has to be close.
        }
        connection.close(); // connection is also closed.
    }

}
