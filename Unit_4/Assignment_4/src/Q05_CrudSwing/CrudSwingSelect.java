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
import java.sql.ResultSet;

public class CrudSwingSelect extends JFrame
{
    public static void main(String[] args)
    {
        CrudSwingSelect frame = new CrudSwingSelect();
        frame.setVisible(true);
        frame.setBounds(500,100,1000,500);
    }

    int id;
    JTextArea textArea;
    Container c;
    public CrudSwingSelect()
    {
         c = this.getContentPane();
         c.setLayout(null);

        //Setting the BackGround Color of the Frame.
        Color clr = new Color(255, 247, 205);
        c.setBackground(clr);

        //Adding 'UserName:' Label
        JLabel idLabel = new JLabel("User Id:");
        idLabel.setBounds(20,10,90,50);
        c.add(idLabel);

        //Adding name text field.
        JTextField idField = new JTextField();
        idField.setBounds(80,25,200,20);
        add(idField);


        //Adding 'Select' Button.
        JButton selectButton = new JButton("Select");
        selectButton.setBounds(290,25,100,25);
        add(selectButton);

        //Adding TextArea
        textArea = new JTextArea();
        textArea.setBounds(80,60,250,200);
        add(textArea);

        selectButton.addActionListener(new ActionListener()

        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

                try
                {
                    id = Integer.parseInt(idField.getText());

                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,"Values aren't acceptable!! 'ID' is not an integer type.","Failure",JOptionPane.ERROR_MESSAGE);
                }

                 SelectFromDatabase();
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void SelectFromDatabase()
    {
        try
        {
            //********************************************* Establishing Connection to the Database ************************************************
            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            //********************** Sql Prepared Statement************************************
            String sql = "select * from students where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            //**************************** show Table *******************************************
            int id=0,age=0;
            String name="",district="";

            while (resultSet.next())
            {
                  id=resultSet.getInt("id");
                  name = resultSet.getString("name");
                  district = resultSet.getString("district");
                  age= resultSet.getInt("age");
            }
            textArea.setText("ID:" + id +"\nName:" +name +"\nDistrict:"+district+"\nAge:"+age);
            statement.close();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}
