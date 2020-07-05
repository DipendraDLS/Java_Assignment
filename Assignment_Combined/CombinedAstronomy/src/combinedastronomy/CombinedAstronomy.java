package combinedastronomy;

import javax.swing.*;
import java.sql.*;

public class CombinedAstronomy extends JFrame
{
    public static void main(String[] args) throws Exception
    {
        CombinedAstronomy frame = new CombinedAstronomy();
        frame.setVisible(true);

    }

    public CombinedAstronomy() throws Exception
    {
        String url = "jdbc:mariadb://localhost:3306/Astronomy";
        String username = "root";
        String password= "";
        Connection connection = DriverManager.getConnection(url,username,password);

        String sql = "select mass , distance from planets";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        //*************** Retrieving the stored value of mass and distance from Database ********************
        Double[] massOfPlanet = new Double[8];
        Double[] distance = new Double[8];
        int i = 0;
        while (resultSet.next())
        {
            massOfPlanet[i] = resultSet.getDouble("mass");
            distance[i] = resultSet.getDouble("distance");
            i++;
        }

        //******************** Calculating Gravitational Force **********************************
        Double G = 6.67430e-11;
        Double ms = 1.989e+30;
        Double[] force = new Double[8];

        //calculating gravitational force and storing it into array.
        for (i = 0; i<force.length; i++)
        {
            force[i] = (G*ms*massOfPlanet[i])/(Math.pow(distance[i],2));
        }

        //******************* Send Calculated Gravitational Force to database ********************
        String insertSql = "UPDATE planets SET gforce = ? WHERE id = (?)";
        PreparedStatement statement1 = connection.prepareStatement(insertSql);
        for (i=1; i<=force.length; i++)
        {
            statement1.setDouble(1,force[i-1]);
            statement1.setInt(2,i);
            statement1.executeUpdate();
        }

        //******** Retrieving overall data of Database along with calculated gravitational force in 2D Array.****
        String selectAllSql = "select * from planets";
        Statement statement2 = connection.createStatement();
        ResultSet resultSet1 = statement2.executeQuery(selectAllSql);

        Object[][] planetDetails = new Object[8][5];
        int row =0;
        while (resultSet1.next())
        {
            planetDetails[row][0] =resultSet1.getInt(1);
            planetDetails[row][1] = resultSet1.getString(2);
            planetDetails[row][2] = resultSet1.getDouble(3);
            planetDetails[row][3] = resultSet1.getDouble(4);
            planetDetails[row][4] = resultSet1.getDouble(5);

            row++;
        }
        statement.close();
        connection.close();

        //**************** Display Values in Table ******************************
        String column[] = {"ID", "Planets", "Mass", "Distance", "Gravitational Force Between Plane and Sun"};
        JTable table = new JTable(planetDetails, column)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        JScrollPane pane = new JScrollPane(table);
        add(pane);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}

