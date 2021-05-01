package swing.layout;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {
    public static void main(String[] args) {
        // create layout, keep a reference to it for swapping components
        CardLayout layout = new CardLayout();

        // create content pane, pass in layout
        JPanel contentPane = new JPanel(layout);

        // Create panels to swap between (see below for createLabeledPanel definition)
        JPanel firstPanel = createLabeledPanel("First Panel");
        JPanel secondPanel = createLabeledPanel("Second Panel");
        JPanel thirdPanel = createLabeledPanel("Third Panel");

        // add components to content pane
        contentPane.add(firstPanel);
        contentPane.add(secondPanel);
        contentPane.add(thirdPanel);

        // to swap by components by name if needed
        layout.addLayoutComponent(firstPanel, "first");
        layout.addLayoutComponent(secondPanel, "second");
        layout.addLayoutComponent(thirdPanel, "third");

        // create UI to allow user to swap components if needed
        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");
        JTextField field = new JTextField(10);
        JLabel instructionLabel = new JLabel("Type first, second, or third. Click enter: ");
        Component emptySpace = Box.createHorizontalStrut(10);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(previous);
        menuBar.add(next);
        menuBar.add(emptySpace);
        menuBar.add(instructionLabel);
        menuBar.add(field);

        // use `CardLayout.previous` and `CardLayout.next` to swap components
        previous.addActionListener(e -> layout.previous(contentPane));
        next.addActionListener(e -> layout.next(contentPane));

        // use `CardLayout.show` to swap by name
        field.addActionListener(e -> layout.show(contentPane, field.getText()));

        // Add components to frame & display
        JFrame frame = new JFrame("CardLayout Demo");
        frame.setJMenuBar(menuBar);
        frame.add(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static JPanel createLabeledPanel(String labelText) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(labelText));
        return panel;
    }
}