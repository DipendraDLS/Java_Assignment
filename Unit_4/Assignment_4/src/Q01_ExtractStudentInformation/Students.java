/*
    Q) Write a Java program using JDBC to extract name of those students who live in Kathmandu district,
       assuming that the student table has four attributes (ID, name, district, and age). [2072]
 */

package Q01_ExtractStudentInformation;
import java.sql.*;
public class Students
{
    public static void main(String[] args) throws SQLException
    {
//********************************************* Establishing Connection to the Database ************************************************

        String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
        String username = "root";
        String password= "";
        Connection connection = DriverManager.getConnection(url,username,password);
// ************************************ Executing SQL Statement ***************************************************************************
        Statement statement= connection.createStatement();
        String sql = "select * from students where district='kathmandu'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            System.out.printf("%d, %s, %s, %d \n",
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("district"),
                    resultSet.getInt("age")
            );
        }
        statement.close();
        connection.close();
    }
}
