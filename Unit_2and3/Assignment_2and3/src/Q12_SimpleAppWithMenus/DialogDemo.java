/*
    Q) Create a simple app with menus. Include a menu item inside the Help menu to show a custom dialog named AboutDialog.
       The dialog must contain your App name, version and copyright information, along with a working close button (JButton).
 */
package Q12_SimpleAppWithMenus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame
{
    public static void main(String[] args)
    {
        DialogDemo frame = new DialogDemo();
        frame.setBounds(500,100,1000,500);
        frame.setVisible(true);
    }
    JDialog dialogBox;
    public DialogDemo()
    {

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem aboutDialog = new JMenuItem("About");
        helpMenu.add(aboutDialog);

        JTextArea textArea = new JTextArea();
        textArea.setText("App Name: TestApp"+ "\n"+"Version: 1.0"+"\n"+"Copyright © 2000-2020 JetBrains s.r.o");
        textArea.setEditable(false);

        JButton closeButton = new JButton("Close");

        aboutDialog.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                dialogBox = new JDialog(DialogDemo.this,"About App");
                dialogBox.setLayout(new FlowLayout());
                dialogBox.setBounds(750,250,300,130);
                dialogBox.setVisible(true);

                dialogBox.add(textArea);
                dialogBox.add(closeButton);
                dialogBox.setResizable(false);
            }
        });

        closeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                dialogBox.dispose();
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
