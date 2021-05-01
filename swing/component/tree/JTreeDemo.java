package swing.component.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class JTreeDemo {
    public static void main(String[] args) {
        // create the tree nodes, starting with the root
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
        rootNode.add(new DefaultMutableTreeNode("First Child"));
        rootNode.add(new DefaultMutableTreeNode("Second Child"));

        // create a tree model, passing in the root node
        DefaultTreeModel model = new DefaultTreeModel(rootNode);

        // create a tree, passing in the model
        JTree tree = new JTree(model);

        // listen for node selection events
        tree.addTreeSelectionListener(event -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            System.out.println(node.getUserObject());
        });

        // Add component to frame & display
        JFrame frame = new JFrame("JTree Demo");
        frame.add(tree);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
