package com.dsa.tree;

/*
Problem: Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
along the path equals the given number. Return false if no such path can be found.
 */

/*
Solution:
1. Pre-order traversal and at each node calculate running sum and subtract from the given number.
2. Pass the balance to next recursive call
3. If balance is zero and reached leaf nodes, then return true else false

It takes O(n) time
 */
public class RootToLeafPathSumEqualToNumber {
    public static void main(String a[]) {
        RootToLeafPathSumEqualToNumber obj = new RootToLeafPathSumEqualToNumber();
        int nodes1[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode treeNode = Tree.getTree(nodes1);
        System.out.println("Path exists from Root To Leaf for given number 15: " + obj.isPathExists(treeNode, 15));
        System.out.println("Path exists from Root To Leaf for given number 25: " + obj.isPathExists(treeNode, 25));
    }

    private boolean isPathExists(TreeNode treeNode, int givenNumber) {

        boolean result = false;

        int balance = treeNode.value - givenNumber;
        if (balance == 0 && treeNode.left == null && treeNode.right == null) {
            return result = true;
        }

        if (treeNode.left != null) {
            result = result || isPathExists(treeNode.left, Math.abs(balance));
        }

        if (treeNode.right != null) {
            result = result || isPathExists(treeNode.right, Math.abs(balance));
        }
        return result;
    }
}
