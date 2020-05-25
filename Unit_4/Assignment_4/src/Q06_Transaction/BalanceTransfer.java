package Q06_Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BalanceTransfer
{
    static Connection connection;
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mariadb://localhost:3306/Bank?useSSL=false";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);

        Scanner in = new Scanner(System.in);
        System.out.println("**** Transfer *****");

        System.out.println("Enter id: ");
        int id = in.nextInt();

        System.out.println("Enter Recipient's id: ");
        int recipientId = in.nextInt();

        System.out.println("Enter amount: ");
        double amount = in.nextDouble();

        try
        {
            String debitSql = "Update MyAccount set balance = balance - ? where id = ?";

            String creditSql = "Update MyAccount set balance = balance + ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(debitSql);
            statement.setDouble(1, amount);
            statement.setInt(2, id);

            PreparedStatement statement1 = connection.prepareStatement(creditSql);
            statement1.setDouble(1, amount);
            statement1.setInt(2, recipientId);

            statement.executeUpdate();
            statement1.executeUpdate();
            connection.commit();
            System.out.println("Amount: Rs " + amount +" has been successfully transferred from id: " + id+
                    " to Recipient's id: "+ recipientId);
        }
        catch (SQLException e)
        {
            connection.rollback();
            System.out.println("Transaction Error!!");
        }
    }
}
