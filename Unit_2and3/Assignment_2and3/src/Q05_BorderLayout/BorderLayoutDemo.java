/*
        Q) Write a program to illustrate the use of BorderLayout. [2073]
 */

package Q05_BorderLayout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame
{
    public static void main(String[] args)
    {
        BorderLayoutDemo frame = new BorderLayoutDemo();
        frame.setVisible(true);
        frame.setTitle("Border Layout");
    }


    public BorderLayoutDemo()
    {
        setLayout(new BorderLayout());

        JButton topButton = new JButton("PAGE_START/NORTH");
        JButton bottomButton = new JButton("PAGE_END/SOUTH");
        JButton leftButton = new JButton("LINE_START/WEST");
        JButton rightButton = new JButton("LINE_END/EAST");
        JButton centerButton = new JButton("CENTER");

        add(topButton,BorderLayout.PAGE_START);
        add(bottomButton,BorderLayout.PAGE_END);
        add(leftButton,BorderLayout.LINE_START);
        add(rightButton,BorderLayout.LINE_END);
        add(centerButton,BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
