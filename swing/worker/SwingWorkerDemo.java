package swing.worker;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingWorkerDemo {
    public static void main(String[] args) {
        JTextField field = new JTextField(10);
        field.setEnabled(false);
        field.setForeground(Color.BLACK);

        JButton button = new JButton("Start");
        button.addActionListener(event -> {
            SwingWorker<Void, Long> worker = new SwingWorker<Void, Long>() {
                @Override
                protected Void doInBackground() {
                    for(long l = 0; l < Long.MAX_VALUE; l++)
                        if(l % 31 == 0)
                            publish(l);
                    return null;
                }

                @Override
                protected void process(List<Long> items) {
                    Long latestItem = items.get(items.size() - 1);
                    field.setText(String.valueOf(latestItem));
                }
            };

            worker.execute();
        });

        JFrame frame = new JFrame("SwingWorker Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(field, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();

        frame.setVisible(true);
    }
}
