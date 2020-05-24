/*
    Q) Create a login form with username and password fields. Print “access granted” if the username and password both are
        “admin”, when user clicks on Login button. If authentication fails, print “access denied”.
 */

package Q07_LoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginFormDemo extends JFrame
{
    public static void main(String[] args)
    {
        LoginFormDemo app   =new LoginFormDemo();
        app.setVisible(true);
    }

    public LoginFormDemo ()
    {
        setLayout(new FlowLayout());
        add(new JLabel("Username"));
        JTextField LoginTextField = new JTextField(5);
        add(LoginTextField);

        add(new JLabel("Password"));
        JPasswordField LoginPasswordField = new JPasswordField(10);
        add(LoginPasswordField);

        JButton LoginButton = new JButton("Login");
        add(LoginButton);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = LoginTextField.getText();
                char[] password = LoginPasswordField.getPassword();
                char[] actualPassword = {'a','d','m','i','n'};

                if (username.equals("admin") && Arrays.equals(actualPassword,password))
                {
                    System.out.println("access granted");
                }
                else
                {
                    System.out.println("access denied");
                }
            }
        });

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}