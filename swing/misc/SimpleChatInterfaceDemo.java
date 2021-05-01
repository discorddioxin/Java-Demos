package swing.misc;

import javax.swing.*;
import java.awt.*;

public class SimpleChatInterfaceDemo {
    public static void main(String[] args) {
        // create components, specifying how many rows/columns (size)
        JTextArea displayArea = new JTextArea(20, 20);
        JTextField inputField = new JTextField(20);

        // listen for actions from field (When user hits Enter)
        inputField.addActionListener(event -> {
            String text = inputField.getText();
            displayArea.append(text + "\n");
            inputField.setText("");
        });


        // Add components to frame & display
        JFrame frame = new JFrame("CardLayout Demo");
        frame.add(displayArea, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
