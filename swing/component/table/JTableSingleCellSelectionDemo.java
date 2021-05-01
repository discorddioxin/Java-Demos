package swing.component.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JTableSingleCellSelectionDemo {
    public static void main(String[] args) {
        // create the table model
        DefaultTableModel model = new DefaultTableModel();

        // configure the table model's columns
        model.addColumn("Name");
        model.addColumn("Age");

        // add rows to the model
        model.addRow(new Object[] { "Bob", 58 });
        model.addRow(new Object[] { "Samantha", 31 });
        model.addRow(new Object[] { "Anthony", 28 });

        // create the table, passing in the model
        JTable table = new JTable(model);

        // enable cell selection
        table.setCellSelectionEnabled(true);

        // adjust the selection mode to your needs
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // listen for cell selections using mouse listener to listen for clicks
        table.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();

                Object data = model.getValueAt(row, column);
                System.out.println(data);
            }
            public void mouseClicked(MouseEvent e) { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e) { }
            public void mouseExited(MouseEvent e) { }
        });

        // grab the table header to add above the table
        JTableHeader header = table.getTableHeader();

        // Add component to frame & display
        JFrame frame = new JFrame("JTable Demo");
        frame.add(header, BorderLayout.NORTH);
        frame.add(table, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
