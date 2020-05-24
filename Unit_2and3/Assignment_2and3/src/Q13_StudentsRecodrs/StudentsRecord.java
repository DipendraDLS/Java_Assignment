/*
     Q) Create a form using JFrame to collect the records of students in Trinity. Each record should contain the
        following information:
            a) First Name (JTextField)
            b) Last Name (JTextField)
            c) Age (JTextField)
            d) Gender (JRadioButton)
            e) Faculty (JComboBox/JList)
            f) Semester (JComboBox/JList)
            g) Remarks (JTextArea)
         Add both menus and toolbars to save the form to a file (display a save dialog). Also add menu/toolbar items
          to reset the form as well as exit the program. Remember to close the file on exit command
 */
package Q13_StudentsRecodrs;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentsRecord extends JFrame
{
    public static void main(String[] args)
    {
        StudentsRecord frame = new StudentsRecord();
        frame.setVisible(true);
        frame.setBounds(500,100,500,800);
        frame.setTitle("Student Records");

    }

    JTextField firstNameField,lastNameField,ageField;
    JRadioButton maleRadioButton,femaleRadioButton;
    JComboBox facultyComboBox,semesterComboBox;
    JTextArea remarksTextArea;
    ButtonGroup group;
    public StudentsRecord()
    {
        setLayout(new GridLayout(18,0));


//****************************** For MenuBar, Menu and MenuItem *****************************************************************
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.green );
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        fileMenu.add(saveMenuItem);

        JMenuItem resetMenuItem = new JMenuItem("Reset");
        fileMenu.add(resetMenuItem);

        fileMenu.addSeparator();
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);


//********************** For JToolBar ******************************************************************************************

        ImageIcon resetIcon = new ImageIcon("resetIcon.png");
        ImageIcon saveIcon = new ImageIcon("saveIcon.png");
        ImageIcon exitIcon = new ImageIcon("exitIcon.png");

        JToolBar toolBar = new JToolBar();
        add(toolBar);

        JButton saveButton = new JButton(saveIcon);
        toolBar.add(saveButton);
        JButton resetButton = new JButton(resetIcon);
        toolBar.add(resetButton);
        JButton exitButton = new JButton(exitIcon);
        toolBar.add(exitButton);


//************************ For JTextField,CheckBox and ComboBox ********************************************************************

        JLabel title = new JLabel("Students Record");
        Font font = new Font("TimesRoman",Font.BOLD,20);
        title.setFont(font);
        title.setHorizontalAlignment(title.CENTER);
        add(title);

        Font font1 = new Font("TimesRoman",Font.ITALIC,16);
        JLabel firstNameLabel = new JLabel("FirstName:");
        firstNameLabel.setFont(font1);
        firstNameField = new JTextField(10);

        JLabel lastNameLabel = new JLabel("LastName:");
        lastNameLabel.setFont(font1);
        lastNameField = new JTextField(10);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(font1);
        ageField = new JTextField(10);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(font1);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        JLabel facultyLabel = new JLabel("Faculty:");
        facultyLabel.setFont(font1);
        String[] facultyList ={"BSC/CSIT","BBM","BIT","Engineering"};
        facultyComboBox = new JComboBox(facultyList);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setFont(font1);
        String[] semesterList ={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester",
                                "6th Semester","7th Semester","8th Semester"};
        semesterComboBox = new JComboBox(semesterList);

        JLabel remarksLabel = new JLabel("Remarks:");
        remarksLabel.setFont(font1);
        remarksTextArea = new JTextArea();


//*********************************************** Adding Label, Fields,RadioButtons, ComboBox and TextArea***********************
        add(firstNameLabel);
        add(firstNameField);

        add(lastNameLabel);
        add(lastNameField);

        add(ageLabel);
        add(ageField);
        add(genderLabel);
        group = new ButtonGroup();

        add(maleRadioButton);
        add(femaleRadioButton);
        group.add(maleRadioButton);
        group.add(femaleRadioButton);

        add(facultyLabel);
        add(facultyComboBox);

        add(semesterLabel);
        add(semesterComboBox);

        add(remarksLabel);
        add(remarksTextArea);

//******************** ActionListener For JButton on ToolBar *****************************************************************************************

        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String[] text = getFieldValue();
                try
                {
                    saveFormData(text);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });

        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                resetMethods();

            }
        });



        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                System.exit(0);
            }
        });

//**************** Action Listener For JMenuItem on Menu ********************************************************************************
        saveMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String[] text = getFieldValue();
                try
                {
                    saveFormData(text);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });




        resetMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                resetMethods();
            }
        });
        exitMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                System.exit(0);
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//********************** Methods for Reset and Save ********************************************************************************
    private void resetMethods()
    {
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        group.clearSelection();
        facultyComboBox.setSelectedIndex(0);
        semesterComboBox.setSelectedIndex(0);
        remarksTextArea.setText("");
    }

    private String[] getFieldValue()
    {
        maleRadioButton.setActionCommand("Male");
        femaleRadioButton.setActionCommand("Female");

        String[] text = {
                firstNameField.getText(),
                lastNameField.getText(),
                ageField.getText(),
                group.getSelection().getActionCommand(),
                (String)facultyComboBox.getSelectedItem(),
                (String)semesterComboBox.getSelectedItem(),
                remarksTextArea.getText()
        };
        return text;
    }


    private void saveFormData (String[] text) throws IOException
    {
        String userDir = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser(userDir+"/Desktop");

        chooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        chooser.setSelectedFile(new File(".txt"));
        int result = chooser.showSaveDialog(this);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            PrintWriter out = null;
            try
            {

                out = new PrintWriter(file);
                for (int i=0; i<text.length; i++)
                {

                    out.print(text[i]+"\n");

                }
            }
            finally
            {
                out.close();
            }
        }
        else
            return;
    }
}
