/*
    Q)Implement CRUD operations for student table in Swing. Ask for user input where applicable.
*/
package Q05_CrudSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CrudSwingDelete extends JFrame
{
    public static void main(String[] args)
    {
        CrudSwingDelete frame = new CrudSwingDelete();
        frame.setVisible(true);
        frame.setBounds(500,100,500,100);
    }
    public CrudSwingDelete()
    {
        setLayout(new GridLayout(2,1,10,5));
        JLabel idLabel = new JLabel("Id:");
        add(idLabel);
        JTextField idTextField = new JTextField(20);
        add(idTextField);

        JLabel Label = new JLabel();
        add(Label);

        JButton deleteButton = new JButton("Delete");
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    int id = Integer.parseInt(idTextField.getText());
                    DeleteFromDatabase(id);
                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,"Values aren't acceptable!! Either fields are empty or type mismatched.","Failure",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void DeleteFromDatabase(int id)
    {
        try
        {
            //********************************************* Establishing Connection to the Database ************************************************

            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";    //For connection we need 'username' and 'password'
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            // ************* Sql prepared statement *************************
            String sql = "delete from students where id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            //************* Binding Parameters ***************************
            statement.setInt(1, id);

            int rowDeleted = statement.executeUpdate();

            //******************** message for user if rows are  successfully deleted or not ******
            if (rowDeleted > 0)
                JOptionPane.showMessageDialog(null,"Row deleted Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);

            else
                JOptionPane.showMessageDialog(null,"Row can't be deleted.","Failure`",JOptionPane.ERROR_MESSAGE);

            statement.close();
            connection.close();

        }
        catch (Exception e)
        {

        }
    }
}
