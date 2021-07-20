package com.dsa.tree;

/*
Problem Description:
Given a sorted array(ascending order) with unique integer elements, write an algorithm to create a BST with minimum height
 */

/*
Solution: Using recursion
1. Insert into the tree the middle element of the array
2. Insert (into the left subtree) the left subarray elements
2. Insert (into the right subtree) the right subarray elements
4. Recurse
 */

public class BSTWithMinimumHeight {
    public static void main(String a[]) {
        BSTWithMinimumHeight obj = new BSTWithMinimumHeight();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode treeNode = obj.createMinimalHeightBST(input, 0, input.length - 1);
        TreeTraversal.inOrderTraversal(treeNode);
        System.out.println();
        TreeTraversal.preOrderTraversal(treeNode);
        System.out.println();
        TreeTraversal.postOrderTraversal(treeNode);
    }

    TreeNode createMinimalHeightBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalHeightBST(arr, start, mid - 1);
        node.right = createMinimalHeightBST(arr, mid + 1, end);
        return node;

    }

}
