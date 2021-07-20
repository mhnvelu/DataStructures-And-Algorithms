package com.dsa.tree;
/*
Problem: Check if the binary tree is balanced.
Balanced tree can be defined to be a tree such that the heights of the 2 subtrees of any node never differ
 by more than one
 */
/*
Solution:
1. Get height of each subtree and if they differ by >1, then return error
2. While calculating the height of a tree, we traverse the tree(post order traversal) and check if the subtree is balanced
3. This avoids repeated calculation of Height for each node.
4. It takes O(n) time and O(H) space(stack space)
 */

public class TreeIsBalanced {
    public static void main(String a[]) {
        TreeIsBalanced obj = new TreeIsBalanced();
        int nodes[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode root = Tree.getTree(nodes);
        TreeTraversal.postOrderTraversal(root);
        System.out.println("Is Tree Balanced : " + obj.isBalanced(root));
    }

    private boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode root) {

        if (root == null) { // Base case
            return -1;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }

}
