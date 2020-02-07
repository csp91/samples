/** Name: Christopher Padilla
 ** Purpose: Creates a file to local directory with copy of the order
 ** Date: 10 December 2019
 ** Tools: IntelliJ IDE
 ** Version: JDK 13
 ** 
 ** Enter the item no.(e.g 1234) and the quantity. 
 */

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class MailOrder {


    //Window elements
    private JFrame frame;
    private JPanel pane;
    private JTextField itemBox;
    private JTextField quantityBox;
    private JScrollPane secondPane;
    private JTextArea displayArea;
    private JButton[] button = {
            new JButton("Add"),
            new JButton("Submit")
    };


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                //Run GUI
                new MailOrder().mailOrderWindow();
            }
        });
    }

    public void mailOrderWindow() {

        //Create top level
        frame = new JFrame();

        //Creating first panel
        pane = new JPanel();

        //Create textfields
        itemBox = new JTextField(2);
        ((AbstractDocument) itemBox.getDocument()).setDocumentFilter(new NumOnly());
        quantityBox = new JTextField(2);
        ((AbstractDocument) quantityBox.getDocument()).setDocumentFilter(new NumOnly());

        //3 x 2 layout
        pane.setLayout(new GridLayout(3, 2, 10, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        //First row
        pane.add(new JLabel("Item #: "));
        pane.add(itemBox);

        //Second row
        pane.add(new JLabel("Quantity: "));
        pane.add(quantityBox);

        //Third row
        pane.add(button[0]);
        pane.add(button[1]);

        //Create textarea
        displayArea = new JTextArea();
        displayArea.setLineWrap(true);

        //Create second panel
        secondPane = new JScrollPane(displayArea);
        secondPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        secondPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        secondPane.setPreferredSize(new Dimension(0, 200));

        //Add panes
        frame.add(pane, BorderLayout.NORTH);
        frame.add(secondPane, BorderLayout.CENTER);

        //Frame set up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        //"ADD" action listener
        button[0].addActionListener(new ActionListener() {

            String itemText;
            String quantityText;

            @Override
            public void actionPerformed(ActionEvent e) {

                //Retrieve textfields
                itemText = itemBox.getText();
                quantityText = quantityBox.getText();

                if(!(itemText.equals("") || quantityText.equals("")) )
                //Prints text
                displayArea.append("Item: " + itemText + "  (QTY: " + quantityText + ")\n");

                //Reset textfields
                itemBox.setText("");
                quantityBox.setText("");
            }
        });

        //"SUBMIT" action listener
        button[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Prints success plus local directory
                submit(displayArea.getText());
                displayArea.append("File has been created. \nCheck " + Paths.get(".").toAbsolutePath().normalize().toString());
            }
        });
    } //END method - mailOrderWindow

    public void submit(String str) {

        String out = new SimpleDateFormat("yyyy-MMM-dd").format(new Date());

        File file = new File("./" + out + ".txt");

        try {
            PrintWriter output = new PrintWriter(file);
            output.print(str);
            output.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error has occurred");
        }
    } //END method - submit
	
} //END primary class - MailOrder


class NumOnly extends DocumentFilter {

    //Regex allow number and "" (empty string)
    private Pattern regexCheck = Pattern.compile("[0-9]+||^$");

    //if matches then allow to insert
    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        if (regexCheck.matcher(str).matches()) {
            super.insertString(fb, offs, str, a);
        }
    }

    //if matches then allow to replace
    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
            throws BadLocationException {
        if (str == null) {
            return;
        }

        if (regexCheck.matcher(str).matches()) {
            fb.replace(offset, length, str, attrs);
        }
    }
} //END class - NumOnly (DocFilter)
