/*
    Q) Write a program using swing components to multiply two numbers. Use text fields for inputs and
       output. Your program should display the result when the user presses a button. [2070]
 */

package Q02_MultiplyTwoNumbers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplyTwoNumbers extends JFrame
{
    public static void main(String[] args)
    {
        MultiplyTwoNumbers frame = new MultiplyTwoNumbers();
        frame.setVisible(true);
        frame.setBounds(500,100,250,250);

    }
    public MultiplyTwoNumbers()
    {
        setLayout(new FlowLayout());
        JLabel firstTextFieldLabel = new JLabel("First Number:");
        JTextField firstTextField = new JTextField(20);
        add(firstTextFieldLabel);
        add(firstTextField);
        firstTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); //optional --> to insert values from right to left.

        JLabel secondTextLabel = new JLabel("Second Number:");
        JTextField secondTextField = new JTextField(20);
        add(secondTextLabel);
        add(secondTextField);
        secondTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JLabel displayResultLabel = new JLabel("Result:");
        JTextField displayResultField = new JTextField(20);
        add(displayResultLabel);
        add(displayResultField);
        displayResultField.setEditable(false);
        displayResultField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JButton calculateProduct = new JButton("Calculate Product");
        add(calculateProduct);

        calculateProduct.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double firstNumber = Double.parseDouble(firstTextField.getText());
                double secondNumber = Double.parseDouble(secondTextField.getText());
                double sum = firstNumber * secondNumber;
                displayResultField.setText(String.valueOf(sum));
            }
        });
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
