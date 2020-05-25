/*
    Q) Implement account balance transfer operation (use transactions).
       Ask for user input where applicable.
 */

package Q06_Transaction;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class BalanceDeposit
{
    static Connection connection;
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mariadb://localhost:3306/Bank?useSSL=false";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);

        Scanner in = new Scanner(System.in);
        System.out.println("**** Deposit *****");

        System.out.println("Enter id: ");
        int id = in.nextInt();

        System.out.println("Enter amount: ");
        double amount = in.nextDouble();

        try {
            String debitSql = "Update MyAccount set balance = balance + ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(debitSql);
            statement.setDouble(1, amount);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println("Transaction Error!!");
        }
    }
}
