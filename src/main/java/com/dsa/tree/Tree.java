package com.dsa.tree;

public class Tree {

    public static TreeNode getTree(int nodes[]) {
        return insertLevelOrder(nodes, null, 0);
    }

    /*
     if parent node is at index i in the array then the left child of that node is at index (2*i + 1) and right child is at
     index (2*i + 2) in the array
     */
    private static TreeNode insertLevelOrder(int nodes[], TreeNode root, int index) {
        if (index < nodes.length) {
            TreeNode temp = new TreeNode(nodes[index]);
            root = temp;
            root.left = insertLevelOrder(nodes, root.left, 2 * index + 1);
            root.right = insertLevelOrder(nodes, root.right, 2 * index + 2);
        }
        return root;
    }

    public static int heightOfTree(TreeNode root) {
        return findHeight(root);
    }

    // post order traversal , then decide height for each node
    private static int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}
