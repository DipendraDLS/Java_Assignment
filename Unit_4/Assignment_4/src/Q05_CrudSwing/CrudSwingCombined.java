/*
    Q)Implement CRUD operations for student table in Swing. Ask for user input where applicable.
 */

package Q05_CrudSwing;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

//******************* Creating Class 'Student' to pass the Class to List<> Interface **********************************************************
class Student
{
    public int id;
    public String name;
    public String district;
    public int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, String district, int age)
    {
        this.id = id;
        this.name = name;
        this.district = district;
        this.age = age;

    }
}
//*********************************************************************************************************************************************
//*********************** Main Coding Begins from here ************************************************************
public class CrudSwingCombined extends JFrame
{
    public static void main(String[] args) {
        CrudSwingCombined frame = new CrudSwingCombined();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(500, 50, 500, 700);

    }

    String name, district;
    int age = NULL, id=NULL;


    List<Student> list = null;
    AbstractTableModel model;
    public CrudSwingCombined()
    {
        JPanel mainPanel = new JPanel();

        //*************** Creating JPanel for label and Fields ****************************************
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 1, 10, 20));


        JLabel idLabel = new JLabel("Id:(Update & Delete purpose only)");
        panel1.add(idLabel);
        JTextField idTextField = new JTextField(20);
        panel1.add(idTextField);

        JLabel nameLabel = new JLabel("Name:");
        panel1.add(nameLabel);
        JTextField nameTextField = new JTextField(20);
        panel1.add(nameTextField);

        JLabel districtLabel = new JLabel("District:");
        panel1.add(districtLabel);
        JTextField districtTextField = new JTextField(20);
        panel1.add(districtTextField);

        JLabel ageLabel = new JLabel("Age:");
        panel1.add(ageLabel);
        JTextField ageTextField = new JTextField(20);
        panel1.add(ageTextField);


        //******************** Creating Panel For Buttons ******************************************
        JPanel panel2 = new JPanel();


        //Adding Insert Button
        JButton insertButton = new JButton("Insert");
        panel2.add(insertButton);


        //Adding Update Button
        JButton updateButton = new JButton("Update");
        panel2.add(updateButton);


        //Adding Delete Button
        JButton deleteButton = new JButton("Delete");
        panel2.add(deleteButton);


        //Adding Reset Button
        JButton resetButton = new JButton("Reset");
        panel2.add(resetButton);


        //******************** Creating Panel For JTable ******************************************
        JPanel panel3 = new JPanel();
        try
        {
            SelectFromDatabase();
        }
        catch (Exception e)
        {

        }

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        panel3.add(pane);

        //************************* Adding panel1, panel2, panel3 into mainPanel ******************************
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        add(mainPanel);

        //************************ Reset Button ActionEvent **************************************************
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                idTextField.setText("");
                nameTextField.setText("");
                districtTextField.setText("");
                ageTextField.setText("");
            }
        });

        //************************* Insert Button ActionEvent **************************************************
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                name = nameTextField.getText();
                district = districtTextField.getText();

                try {
                    age = Integer.parseInt(ageTextField.getText());

                } catch (NumberFormatException e) {

                }
                if (name.equals("") || district.equals("") || age == NULL) {
                    JOptionPane.showMessageDialog(null, "Values aren't acceptable!! Either fields are empty or 'Age'  is not an integer type.", "Failure", JOptionPane.ERROR_MESSAGE);
                }
                else
                    {
                        try
                        {
                            DatabaseConnection();
                            InsertIntoDatabase(name, district,age);
                        }
                        catch (Exception e)
                        {

                        }
                     }

            }
        });
        //************************************** Update Button ActionEvent ****************************************************
        updateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                name = nameTextField.getText();
                district = districtTextField.getText();
                try
                {
                    id = Integer.parseInt(idTextField.getText());
                    age = Integer.parseInt(ageTextField.getText());
                }
                catch (NumberFormatException e)
                {

                }
                if (name.equals("") || district.equals("") || age == NULL||id == NULL)
                {
                    JOptionPane.showMessageDialog(null, "Values aren't acceptable!! Either fields are empty or 'id','Age' is not an integer type.", "Failure", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try
                    {
                        DatabaseConnection();
                        UpdateIntoDatabase(id, name, district ,age);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        });

        //************************************** Delete Button ActionEvent ****************************************************

        deleteButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                try
                {
                    id = Integer.parseInt(idTextField.getText());
                }
                catch (Exception e)
                {

                }

                if(id == NULL)
                {
                    JOptionPane.showMessageDialog(null, "Values aren't acceptable!! Either'id' is not an integer type or 'id' field is empty.", "Failure", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try
                    {
                        DatabaseConnection();
                        DeleteFromTable(id);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

//****************************************Database Connection *************************************************
    Connection connection;
    public void DatabaseConnection()throws Exception
    {
            String url = "jdbc:mariadb://localhost:3306/JavaJDBC";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);

    }
//*************************************** Insert Into DataBase ************************************************
    public void InsertIntoDatabase(String name, String district, int age) throws Exception
    {
            //************************** Sql prepared statement ***********************************************
            String sql = String.format("Insert into students (name,district,age) Values (?,?,?)");

            PreparedStatement statement = connection.prepareStatement(sql);

            //****************** Binding Parameter ************************************************************
            statement.setString(1, name);
            statement.setString(2, district);
            statement.setInt(3, age);
            int rowInserted = statement.executeUpdate();

            //******************** message for user if rows are  successfully updated or not **********
            if (rowInserted > 0)
                JOptionPane.showMessageDialog(null, "Row Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Row isn't Inserted Successfully", "Failure", JOptionPane.ERROR_MESSAGE);
            statement.close();
            connection.close();
    }


//***************************************** Update into Database *********************************************
        public void UpdateIntoDatabase(int id, String name, String district, int age) throws Exception
        {
            //************************** Sql prepared statement ***********************************************
            String sql = String.format("update students set name = ?,district= ?, age = ? where id= ?");

            PreparedStatement statement = connection.prepareStatement(sql);

            //****************** Binding Parameter ************************************************************
            statement.setString(1, name);
            statement.setString(2, district);
            statement.setInt(3, age);
            statement.setInt(4,id);
            int rowInserted = statement.executeUpdate();

            //******************** message for user if rows are  successfully updated or not **********
            if (rowInserted > 0)
                JOptionPane.showMessageDialog(null, "Row Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Row isn't Updated Successfully", "Failure", JOptionPane.ERROR_MESSAGE);

            statement.close();
            connection.close();
        }



//**************************************** Delete From Database *********************************************
    public void DeleteFromTable(int id) throws Exception
    {
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


//**************************************** Select From Database *********************************************
    public void SelectFromDatabase() throws Exception
    {
        DatabaseConnection();
        Statement statement= connection.createStatement();

        String sql = "select * from students";
        ResultSet resultSet = statement.executeQuery(sql);

        //*********************** List<> interface implementation*****************************************
        list = new ArrayList<>();

        //************************ To get all the record from the database.********************************
        while (resultSet.next())
        {
            int id=resultSet.getInt("id");
            String name=resultSet.getString("Name");
            String district = resultSet.getString("district");
            int age=resultSet.getInt("age");
            list.add(new Student(id,name,district,age));       //adding database values to the List<> interface object 'list'
        }
        int size = list.size();

        // ******************* Overriding functions of AbstractTableModel ************************************
        model = new AbstractTableModel()
        {
            String[] columnNames = { "id", "name", "district", "age"};

            public String getColumnName(int column)
            {
                return columnNames[column].toString();
            }

            public int getRowCount()
            {
                return size;
            }

            public int getColumnCount()
            {
                return columnNames.length;
            }

            public boolean isCellEditable(int row, int column)
            {
                return false;
            }


            public Object getValueAt(int row, int column)
            {
                Object value = null;
                Student s = list.get(row);
                switch (column)
                {
                    case 0:
                        value= s.id;
                        break;
                    case 1:
                        value = s.name;
                        break;
                    case 2:
                        value = s.district;
                        break;
                    case 3:
                        value = s.age;
                        break;
                }
                return  value;
            }
            public void setValueAt(Object value, int row, int column)
            {
                Student s = list.get(row);
                switch (column)
                {
                    case 0:
                        if(value instanceof  Integer)
                        {
                            s.setId((Integer)value);
                        }
                        break;
                    case 1:
                        s.setName(value.toString());
                        break;
                    case 2:
                        s.setDistrict(value.toString());
                        break;
                    case 3:
                        s.setAge((Integer)value);
                        break;
                }
                fireTableCellUpdated(row, column);
            }

//            public Class getColumnClass(int c)
//            {
//                return getValueAt(0, c).getClass();
//            }
        };
        statement.close();
        connection.close();



    }





}
