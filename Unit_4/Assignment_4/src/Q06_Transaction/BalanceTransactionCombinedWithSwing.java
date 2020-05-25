/*
  Q)Implement account balance transfer operation (use transactions). Ask for user input where applicable.
 */
package Q06_Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceTransactionCombinedWithSwing extends JFrame {
    public static void main(String[] args) {
        BalanceTransactionCombinedWithSwing frame = new BalanceTransactionCombinedWithSwing();
        frame.setBounds(500, 100, 600, 250);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public BalanceTransactionCombinedWithSwing() {
// **************************** Adding GUI of Swing *************************************************************************
        JPanel mainPanel = new JPanel();

        //*************** Creating JPanel for label and Fields ****************************************
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1, 10, 20));


        JLabel currentBalanceLabel = new JLabel("Current Balance:");
        panel1.add(currentBalanceLabel);
        JTextField currentBalanceTextField = new JTextField(20);
        currentBalanceTextField.setEditable(false);
        panel1.add(currentBalanceTextField);

        JLabel idLabel = new JLabel("User Id:");
        panel1.add(idLabel);
        JTextField idTextField = new JTextField(20);
        panel1.add(idTextField);

        JLabel recipientIdLabel = new JLabel("Recipient Id:\n(For transfer purpose only)");
        panel1.add(recipientIdLabel);
        JTextField recipientIdTextField = new JTextField(20);
        panel1.add(recipientIdTextField);

        JLabel amountLabel = new JLabel("Amount:");
        panel1.add(amountLabel);
        JTextField amountTextField = new JTextField(20);
        panel1.add(amountTextField);


        //******************** Creating Panel For Buttons ******************************************
        JPanel panel2 = new JPanel();

        //Adding Withdraw Button
        JButton withdrawButton = new JButton("Withdraw");
        panel2.add(withdrawButton);


        //Adding Deposit Button
        JButton depositButton = new JButton("Deposit");
        panel2.add(depositButton);


        //Adding Transfer Button
        JButton transferButton = new JButton("Transfer");
        panel2.add(transferButton);


        //Adding Check Balance Button
        JButton checkBalanceButton = new JButton("Check Balance");
        panel2.add(checkBalanceButton);

        //************************* Adding panel1, panel2, panel3 into mainPanel ******************************
        add(mainPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel2);

//************* Check Balance Button Action Event ****************************************************************
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DatabaseConnection();
                try {
                    int FieldId = Integer.parseInt(idTextField.getText());
                    if (CheckUserId(FieldId) == true) {
                        currentBalanceTextField.setText("Your Current Balance is: Rs " + CheckBalanceMethod(FieldId)); //Setting the database balance field value to currentBalanceTextField
                    } else {
                        JOptionPane.showMessageDialog(null, "User doesn't exist with id: " + FieldId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Id must be passed to check the current balance and it's type must be integer", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
//**************************** Withdraw Button Action Event *************************************************************************************
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int FieldId = Integer.parseInt(idTextField.getText());
                    int amount = Integer.parseInt(amountTextField.getText());
                    DatabaseConnection();
                    Integer dbBalance = CheckBalanceMethod(FieldId); //Inorder to accept the 'null' value as well, the type is made to Integer.

                    //To check whether user exist or not if 'CheckBalanceMethod' returns 'null' then that means 'userid' doesn't exists.
                    if (CheckUserId(FieldId) == true) {
                        WithdrawAmount(FieldId, amount, dbBalance);
                    } else {
                        JOptionPane.showMessageDialog(null, "User doesn't exist with id: " + FieldId, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "'User Id' and 'Amount'fields shouldn't be empty and values must be an integer type.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

//**************************** Deposit Button Action Event *************************************************************************************
        depositButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int FieldId = Integer.parseInt(idTextField.getText());
                    int amount = Integer.parseInt(amountTextField.getText());
                    DatabaseConnection();


                    //To check whether user exist or not if 'CheckBalanceMethod' returns 'null' then that means 'userid' doesn't exists and balance is null.
                    if (CheckUserId(FieldId) == true) {
                        DepositAmount(FieldId, amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "User doesn't exist with id: " + FieldId, "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "'User Id' and 'Amount'fields shouldn't be empty and values must be an integer type.", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });



//**************************** Transfer Button Action Event *************************************************************************************
        transferButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try {
                    int FieldId = Integer.parseInt(idTextField.getText());
                    int recipientId = Integer.parseInt(recipientIdTextField.getText());
                    int amount = Integer.parseInt(amountTextField.getText());
                    DatabaseConnection();


                    //To check whether user exist or not if 'CheckBalanceMethod' returns 'null' then that means 'userid' doesn't exists and balance is null.
                    if ((CheckUserId(FieldId) & CheckUserId(recipientId)) == true) {
                       TransferAmount(FieldId,recipientId,amount);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid User id or recipient id.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "'User Id' and 'Amount'fields shouldn't be empty and values must be an integer type.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //******************************** All the Methods Details for Transaction Operation *********************************************
//************************* Method for Database Connection ************************************************************
    Connection connection;

    public void DatabaseConnection() {
        try {
            String url = "jdbc:mariadb://localhost:3306/Bank?useSSL=false";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

        }
    }

    //***************************** Method for Check UserId ****************************************************************
    public Boolean CheckUserId(int id) {
        try {
            String sql = "select id from MyAccount where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                dbId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
        }

        if (dbId == id) //Checking whether user with given id i.e 'FieldId' exists in database or not. if exists then only return balance.
            return true;
        else                // If user with given id doesn't matched with database id then return 'null'
            return false;
    }

    //****************************** Method for  checkBalance ****************************************************************
    int balance, dbId;

    public Integer CheckBalanceMethod(int id) //if we place return type as 'int' it's a primitive type and can't return null.
    {
        try {
            String sql = "select balance from MyAccount where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                balance = resultSet.getInt("balance"); //Fetching out database 'balance' field value.
            }
        } catch (SQLException e) {
        }
        return balance;
    }


    //************************ Method for Withdraw Amount ********************************************************************************************
    public void WithdrawAmount(int id, int amount, int dbBalance) throws SQLException {
        connection.setAutoCommit(false); // disable auto commit after each "execute"
        try {
            //User shouldn't withdraw the amount if it's greater than the actual amount present in database.
            if (dbBalance >= amount) {
                String debitSql = "Update MyAccount set balance = balance - ? where id= ?";
                PreparedStatement statement = connection.prepareStatement(debitSql);
                statement.setInt(1, amount);
                statement.setInt(2, id);
                int rowUpdated = statement.executeUpdate();
                connection.commit();
                JOptionPane.showMessageDialog(null, "Rs: " + amount + " has been withdrawn from Account id: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);

            } else
                throw new SQLException();
        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Transaction Error", "Failure", JOptionPane.ERROR_MESSAGE);
        }

    }
//************************ Method for Deposit Amount *******************************************************************************************

    public void DepositAmount(int id, int amount) throws SQLException {
        connection.setAutoCommit(false); // disable auto commit after each "execute"
        try {
            String debitSql = "Update MyAccount set balance = balance + ? where id= ?";
            PreparedStatement statement = connection.prepareStatement(debitSql);
            statement.setInt(1, amount);
            statement.setInt(2, id);
            statement.executeUpdate();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Rs: " + amount + " has been Deposited to Account id: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            connection.rollback();
            JOptionPane.showMessageDialog(null, "Transaction Error", "Failure", JOptionPane.ERROR_MESSAGE);
        }
    }
//************************************ Method for Transfer Amount *******************************************************************************************

    public void TransferAmount(int id, int recipientId, int amount) throws SQLException
    {
        connection.setAutoCommit(false); // disable auto commit after each "execute"
        Integer senderBalance;
        senderBalance = CheckBalanceMethod(id);
        if(senderBalance>=amount)
        {
            try {
                String debitSql = "Update MyAccount set balance = balance - ? where id = ?";

                String creditSql = "Update MyAccount set balance = balance + ? where id = ?";

                PreparedStatement statement = connection.prepareStatement(debitSql);
                statement.setInt(1, amount);
                statement.setInt(2, id);

                PreparedStatement statement1 = connection.prepareStatement(creditSql);
                statement1.setInt(1, amount);
                statement1.setInt(2, recipientId);

                statement.executeUpdate();
                statement1.executeUpdate();
                connection.commit();

                if(id == recipientId)
                {
                    JOptionPane.showMessageDialog(null, "User can't transfer balance to their own account!!", "Error", JOptionPane.ERROR_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Rs: " + amount + " has been transferred to Account id: " + recipientId + " from account id:" +id, "Success", JOptionPane.INFORMATION_MESSAGE);

                }
            }
            catch (SQLException e)
            {
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Transaction Error", "Failure", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Insufficient balance on user account with id: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
