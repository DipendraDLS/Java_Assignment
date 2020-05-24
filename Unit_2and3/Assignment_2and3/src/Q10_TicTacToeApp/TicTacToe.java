/*
    Q) Create the UI for tic-tac-toe app using JButton array and GridLayout.
 */

package Q10_TicTacToeApp;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame
{
    public static void main(String[] args)
    {
        TicTacToe frame = new TicTacToe();
        frame.setBounds(500,100,500,500);
        frame.setVisible(true);
    }
    public TicTacToe()
    {
        JButton[] JButtonArray = new JButton[9];
        setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++)
        {
            JButtonArray[i] = new JButton();
            add(JButtonArray[i]);
        }
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
