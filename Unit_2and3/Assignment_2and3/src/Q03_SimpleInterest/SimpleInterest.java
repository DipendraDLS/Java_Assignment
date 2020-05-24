/*
   Q) Write a program using swing components to find simple interest. Use text fields for inputs and output.
      Your program should display the result when the user presses a button. [2071, 2074]
 */

package Q03_SimpleInterest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleInterest extends JFrame
{
    public static void main(String[] args)
    {
        SimpleInterest frame = new SimpleInterest();
        frame.setVisible(true);

    }

    public SimpleInterest()
    {

        //place your code here
        setLayout(new FlowLayout());


        add(new JLabel("Principle"));
        JTextField principleTextField = new JTextField(5);
        add(principleTextField);

        add(new JLabel("Time"));
        JTextField timeTextField = new JTextField(5);
        add(timeTextField);

        add(new JLabel("Rate"));
        JTextField rateTextField = new JTextField(5);
        add(rateTextField);


        add(new JLabel("Interest"));
        JTextField interestTextField =new JTextField(10);
        interestTextField.setEditable(false);
        add(interestTextField);

        JButton calculateInterest = new JButton("Calculate Inrerest");
        add(calculateInterest);

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