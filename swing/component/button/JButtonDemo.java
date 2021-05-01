package swing.component.button;

import javax.swing.*;
import java.awt.*;

public class JButtonDemo {
    public static void main(String[] args) {
        // create the button
        JButton button = new JButton();

        // listen for actions from the button (pressing the button)
        button.addActionListener(event -> System.out.println("Clicked"));

        // set an icon
        button.setIcon(new ImageIcon(JButtonDemo.class.getResource("res/button_icon.png")));

        // change the border
        button.setBorder(BorderFactory.createLineBorder(Color.RED));

        // change the color
        button.setBackground(Color.ORANGE);

        // Add component to frame & display
        JFrame frame = new JFrame("JButton Demo");
        frame.add(button);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
