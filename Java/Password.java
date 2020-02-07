/** Name: Christopher Padilla
 ** Purpose: Samples an account creation w/ username and password fields using Swing utilities.
 ** Date: 01 December 2019
 ** Tools: IntelliJ IDE
 ** Version: JDK 13
 ** Password must have 6-10 characters with at least a number and a (a-zA-Z)character.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.lang.Character;

public class Password {

    private JFrame frame;
    private JPanel pane;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField secondPassword;

    public static void main(String[] args) {

        //Swing utilities aren't thread safe. Setting task asynchronously
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                //Run application
                new Password().accountCreationWindow();
            }
        });
    }


    public void accountCreationWindow() {

        //Creating a customized form or window
        pane = new JPanel();

        //3 x 2 layout
        pane.setLayout(new GridLayout(3, 2, 2, 2));

        //Creating objects
        username = new JTextField(2);
        password = new JPasswordField(2);
        secondPassword = new JPasswordField(2);

        //Add username field
        pane.add(new JLabel("Username: "));
        pane.add(username);

        //Add password field
        pane.add(new JLabel("Password: "));
        pane.add(password);

        //Add second password field for confirmation
        pane.add(new JLabel("Confirm Password: "));
        pane.add(secondPassword);


        //Loop for possible errors
            while (true) {

                //Create option within created frame.
                int option = JOptionPane.showConfirmDialog(frame, pane, "Create your account.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                //OK OPTION
                if (option == JOptionPane.OK_OPTION) {

                    //Get user input
                    String user = username.getText();
                    char[] passwordText = password.getPassword();
                    char[] secondPasswordText = secondPassword.getPassword();

                    //Check user input
                    if (user.length() == 0) {  //username field is empty : ERROR!

                        password.setText("");
                        secondPassword.setText("");

                        JOptionPane.showMessageDialog(null, "Please enter a username.", "Error", JOptionPane.WARNING_MESSAGE);

                    } else if (passwordText.length < 6 || passwordText.length > 10) { //Password is less than 6 but more than 10 : ERROR !

                        JOptionPane.showMessageDialog(null, "Password has to be more than 6 but less than 10 characters.", "Error", JOptionPane.WARNING_MESSAGE);

                        Arrays.fill(passwordText, '0');
                        Arrays.fill(secondPasswordText, '0');

                        password.setText("");
                        secondPassword.setText("");

                    } else if (!Arrays.equals(passwordText, secondPasswordText)) { //Password and second password field don't match : ERROR !!

                        Arrays.fill(passwordText, '0');
                        Arrays.fill(secondPasswordText, '0');

                        password.setText("");
                        secondPassword.setText("");

                        JOptionPane.showMessageDialog(null, "Password did not match.", "Error", JOptionPane.WARNING_MESSAGE);


                    } else if (isValid(passwordText)) { //Password field has valid characters : GOOD !!

                        //Creates a second window / form to display result!
                        pane = new JPanel();
                        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

                        //First line
                        pane.add(new JLabel("Welcome " + user + "!"));
                        //Second Line
                        pane.add(new JLabel("Your account has been created."));

                        //Display
                        JOptionPane.showMessageDialog(frame, pane);

                        //End application !!!
                        System.exit(0);

                    } else { //Any other error

                        //Resets all variables
                        Arrays.fill(passwordText, '0');
                        Arrays.fill(secondPasswordText, '0');

                        //Reset field except username
                        password.setText("");
                        secondPassword.setText("");

                        //Error
                        JOptionPane.showMessageDialog(null, "Please enter a number and a letter for your password.", "Error", JOptionPane.WARNING_MESSAGE);

                    }
                } else {

                    System.exit(0);

                }
        }
    }

    //Check for digits and num function
    private boolean isValid(char[] charArray) {

        boolean hasNum = false;
        boolean hasABC = false;

        //Linear search for alphabet
        for (int i = 0; i < charArray.length; i++) {

            if (Character.isLetter(charArray[i])) {
                hasABC = true;
                break;
            }
        }
        //Linear search for digits
        for (int i = 0; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                hasNum = true;
                break;
            }
        }

        //If charArray has num and abc char, return true. Else return false.
        if (hasABC && hasNum) {
            return true;
        }
        return false;
    }
}



