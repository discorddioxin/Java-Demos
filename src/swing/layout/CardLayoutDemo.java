package swing.layout;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardLayout layout = new CardLayout();

            // Create content pane, add layout
            JPanel contentPane = new JPanel();
            contentPane.setLayout(layout);

            // Create panels to swap between
            JPanel firstPanel = createLabeledPanel("First Panel");
            JPanel secondPanel = createLabeledPanel("Second Panel");
            JPanel thirdPanel = createLabeledPanel("Third Panel");

            // Add panels to layout, this part is only needed to allow swapping panels by name
            layout.addLayoutComponent(firstPanel, "first");
            layout.addLayoutComponent(secondPanel, "second");
            layout.addLayoutComponent(thirdPanel, "third");

            // Panels must be added to pane too
            contentPane.add(firstPanel);
            contentPane.add(secondPanel);
            contentPane.add(thirdPanel);

            // Create menu to let user switch between panels
            JMenuBar menuBar = new JMenuBar();
            JButton previous = new JButton("Previous");
            JButton next = new JButton("Next");
            JTextField panelNameField = new JTextField(10);

            // Add actions to the buttons
            previous.addActionListener(e -> layout.previous(contentPane));
            next.addActionListener(e -> layout.next(contentPane));

            // Add action to the field
            panelNameField.addActionListener(e -> {
                layout.show(contentPane, panelNameField.getText());
                panelNameField.setText("");
            });

            // Components to improve usability
            JLabel instructionLabel = new JLabel("Type first, second, or third. Click enter: ");
            Component emptySpace = Box.createHorizontalStrut(10);

            // Add components to menu in proper order
            menuBar.add(previous);
            menuBar.add(next);
            menuBar.add(emptySpace);
            menuBar.add(instructionLabel);
            menuBar.add(panelNameField);

            // Create window
            JFrame frame = new JFrame("CardLayout Demo");

            // Add menu and content pane, pack so window fits around added components
            frame.setJMenuBar(menuBar);
            frame.setContentPane(contentPane);
            frame.pack();

            // Let OS determine where to open window, terminate the program when user closes window
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Display window
            frame.setVisible(true);
        });

    }

    static JPanel createLabeledPanel(String labelText) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(labelText));
        return panel;
    }
}