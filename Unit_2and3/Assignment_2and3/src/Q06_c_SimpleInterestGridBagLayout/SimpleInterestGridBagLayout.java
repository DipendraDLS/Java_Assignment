/*
    Q) Write a program to calculate simple interest using
        a) FlowLayout
        b) GridLayout
        c) GridBagLayout
 */
package Q06_c_SimpleInterestGridBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterestGridBagLayout extends JFrame
{
    public static void main(String[] args)
    {
        SimpleInterestGridBagLayout app = new SimpleInterestGridBagLayout();
        app.setVisible(true);
    }

    public SimpleInterestGridBagLayout()
    {
        //place your code

        //Defining Layout
        setLayout(new GridBagLayout());
        GridBagConstraints s = new GridBagConstraints(); //GridBagLayout so we have to define Constraints


        //For Principle
        s.gridx =0;
        s.gridy =0;
        add(new JLabel("Principle"));
        JTextField principleTextField = new JTextField(15);
        add(principleTextField);


        //For Rate
        s.gridx =0;
        s.gridy =1;
        add(new JLabel("Time"),s);
        JTextField timeTextField = new JTextField(15);
        s.gridx = 1;
        add(timeTextField,s);


        //For Time
        s.gridx =0;
        s.gridy =2;
        add(new JLabel("Rate"),s);
        JTextField rateTextField = new JTextField(15);
        s.gridx=1;
        add(rateTextField,s);

        //For Interest Displaying Field
        s.gridx =0;
        s.gridy =3;
        add(new JLabel("Interest"),s);
        JTextField interestTextField = new JTextField(15);
        interestTextField.setEditable(false);
        s.gridx =1;
        add(interestTextField,s);


        //For Button
        s.fill =GridBagConstraints.BOTH;
        s.gridx =1;
        s.gridy =5;
        s.gridwidth= 1;
        JButton calculateInterest = new JButton("Calculate Inrerest");
        add(calculateInterest,s);

        calculateInterest.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double principle = Double.parseDouble(principleTextField.getText());
                double rate = Double.parseDouble(rateTextField.getText());
                double time = Double.parseDouble(timeTextField.getText());
                double calculateInterest = (principle*rate*time)/100;

                interestTextField.setText(String.valueOf(calculateInterest));

            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}