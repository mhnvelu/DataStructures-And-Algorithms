package com.dsa.tree;

public class TreeTraversal {

    public static void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.value + " ");
        inOrderTraversal(treeNode.right);
    }

    public static void preOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.value + " ");
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    public static void postOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.value + " ");
    }
}
