package Q06_Transaction;

import java.sql.*;
import java.util.Scanner;

public class BalanceWithdraw
{
    static Connection connection;
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mariadb://localhost:3306/Bank";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);

        Scanner in = new Scanner(System.in);
        System.out.println("**** Withdraw *****");

        System.out.println("Enter id: ");
        int id = in.nextInt();

        System.out.println("Enter amount: ");
        double amount = in.nextDouble();

        try {
            String debitSql = "Update MyAccount set balance = balance - ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(debitSql);
            statement.setDouble(1, amount);
            statement.setInt(2, id);
            statement.executeUpdate();

            connection.commit();
            System.out.println("Amount: " + amount + " has been sucessfully withdrawn from id: "+ id);

        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println("Transaction Error!!");
        }
    }
}
