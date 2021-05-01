package swing.edt;

import javax.swing.*;
import java.awt.*;

/**
 * This code will freeze the GUI! Use your IDE to stop the program
 */
public class EventDispatchThreadDemo {
    public static void main(String[] args) {
        JTextField field = new JTextField(10);
        field.setEnabled(false);
        field.setForeground(Color.BLACK);

        JButton button = new JButton("Start");
        button.addActionListener(event -> {
            Thread thread = new Thread(() -> {
                for (long l = 0; l < Long.MAX_VALUE; l++)
                    if (l % 31 == 0) {
                        long value = l; // variable must be "effectively final"
                        SwingUtilities.invokeLater(() -> field.setText(String.valueOf(value)));
                    }
            });

            thread.start();
        });

        JFrame frame = new JFrame("EDT Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(field, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();

        frame.setVisible(true);
    }
}
