package swing.edt;

import javax.swing.*;
import java.awt.*;

/**
 * This code will freeze the GUI! Use your IDE to stop the program
 */
public class EventDispatchThreadBlockDemo {
    public static void main(String[] args) {
            JTextField field = new JTextField(10);
            field.setEnabled(false);

            JButton button = new JButton("Start");
            button.addActionListener(event -> {
                for(long l = 0; l < Long.MAX_VALUE; l++)
                    if(l % 31 == 0)
                        field.setText(String.valueOf(l));
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
