package swing.component.combobox;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class JComboBoxDemo {
    public static void main(String[] args) {
        // create the combo box
        JComboBox<String> comboBox = new JComboBox<>();

        // add items to the combo box
        comboBox.addItem("One");
        comboBox.addItem("Two");
        comboBox.addItem("Three");

        // listen for item changes
        comboBox.addItemListener(event -> {
            System.out.println("Item: " + event.getItem());

            if(event.getStateChange() == ItemEvent.SELECTED)
                System.out.println("Selected");
            else
                System.out.println("Deselected");

            System.out.println();
        });

        // Add component to frame & display
        JFrame frame = new JFrame("JComboBox Demo");
        frame.add(comboBox);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
