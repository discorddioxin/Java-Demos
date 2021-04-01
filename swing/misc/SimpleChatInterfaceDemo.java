package swing.misc;

import javax.swing.*;
import java.awt.*;

public class SimpleChatInterfaceDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create components, specifying how many rows/columns (to size them)
            JTextArea displayArea = new JTextArea(20, 20);
            JTextField inputField = new JTextField(20);

            // Add action to input text field (When user clicks Enter)
            inputField.addActionListener(event -> {
                // Append text from input text field, include line separator (new line)
                displayArea.append(inputField.getText() + "\n");

                // Clear input text field
                inputField.setText("");
            });

            // Create window
            JFrame frame = new JFrame("Simple Chat Interface Demo");

            // Add components to window - JFrame uses BorderLayout by default
            frame.add(displayArea, BorderLayout.CENTER);
            frame.add(inputField, BorderLayout.SOUTH);

            // Resize window to fit components inside, make window visible
            frame.pack();
            frame.setVisible(true);
        });
    }
}
