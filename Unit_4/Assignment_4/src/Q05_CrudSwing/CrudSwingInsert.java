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

import static java.sql.Types.NULL;

public class CrudSwingInsert extends JFrame
{
    public static void main(String[] args)
    {
        CrudSwingInsert frame = new CrudSwingInsert();
        frame.setVisible(true);
    }

    String name,district;
    int age =  NULL;
    public CrudSwingInsert()
    {
        setLayout(new GridLayout(5,1,5,5));

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
        JButton insertButton = new JButton("Insert");
        add(insertButton);

        insertButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                name = nameTextField.getText();
                district = districtTextField.getText();

                try
                {
                    age = Integer.parseInt(ageTextField.getText());

                }
                catch (NumberFormatException e)
                {

                }
                if(name.equals("")|| district.equals("")|| age == NULL)
                {
                    JOptionPane.showMessageDialog(null,"Values aren't acceptable!! Either fields are empty or 'Age' is not an integer type.","Failure",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                       InsertIntoDatabase();
                }

                }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void InsertIntoDatabase()
    {

        try
        {
            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            setLayout(new GridLayout(5,1,5,5));

            //************************** Sql prepared statement *****************************************
            String sql = String.format("Insert into students (name,district,age) Values (?,?,?)");

            PreparedStatement statement = connection.prepareStatement(sql);

            //****************** Binding Parameter ******************************************************
            statement.setString(1,name);
            statement.setString(2,district);
            statement.setInt(3,age);
            int rowInserted = statement.executeUpdate();

            //******************** message for user if rows are  successfully updated or not **********
            if(rowInserted>0)
                JOptionPane.showMessageDialog(null,"Row Inserted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Row Inserted Successfully","Failure",JOptionPane.ERROR_MESSAGE);
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("Error:"+ e.getMessage());
        }
    }
}
