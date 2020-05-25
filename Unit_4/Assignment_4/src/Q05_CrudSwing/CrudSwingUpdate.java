/*
    Q) Implement CRUD operations for student table in Swing. Ask for user input where applicable
 */
package Q05_CrudSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CrudSwingUpdate extends JFrame
{
    public static void main(String[] args)
    {
        CrudSwingUpdate frame = new CrudSwingUpdate();
        frame.setVisible(true);
        frame.setBounds(500,100,550,250);
    }

    public CrudSwingUpdate()
    {
        setLayout(new GridLayout(5,1,10,20));

        JLabel idLabel = new JLabel("Id:");
        add(idLabel);
        JTextField idTextField = new JTextField(20);
        add(idTextField);

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel);
        JTextField nameTextField = new JTextField(20);
        add(nameTextField);

        JLabel districtLabel = new JLabel("District");
        add(districtLabel);
        JTextField districtTextField = new JTextField(20);
        add(districtTextField);

        JLabel ageLabel = new JLabel("Age");
        add(ageLabel);
        JTextField ageTextField = new JTextField(20);
        add(ageTextField);

        JLabel blankLabel = new JLabel("");
        add(blankLabel);

        JButton updateButton = new JButton("Update");
        add(updateButton);

        updateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    int id = Integer.parseInt(idTextField.getText());
                    String  name = nameTextField.getText();
                    String district = districtTextField.getText();
                    int age = Integer.parseInt(ageTextField.getText());
                    UpdateDatabase(id,name,district,age);

                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,"Values aren't acceptable!! Either Fields are empty or type mismatched.","Failure",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void UpdateDatabase(int id, String name, String district, int age)
    {
        //********************************************* Establishing Connection to the Database ************************************************
        try
        {
            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

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
                JOptionPane.showMessageDialog(null,"Rows update successfully!!.","Success",JOptionPane.INFORMATION_MESSAGE);

            else
                JOptionPane.showMessageDialog(null,"Rows aren't updated!!","Failure",JOptionPane.ERROR_MESSAGE);

            statement.close(); //statement has to be close.
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
