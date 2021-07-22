package com.dsa.tree;

/*
Problem : T1 and T2 are the 2 large binary tress, with t1 much bigger than T2. Write an algorithm
to determine if T2 is a subtree of T1
 */

/*
Solution:
1. Use Pre-order traversal on T1 and T2 and store results in 2 separate strings s1 and s2.
1.1. Tress with different structures could still have same pre-order traversal. so we can store 'X' for
NULL nodes in the pre-order traversal
2. If s2 is substring of s1, then T2 is subtree of T1
3. It takes O(n+m) time and O(n+m) space
 */
public class CheckSubTree1 {
    public static void main(String a[]) {
        CheckSubTree1 obj = new CheckSubTree1();
        int nodes1[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode t1 = Tree.getTree(nodes1);
        int nodes2[] = {4, 2, 8};
        TreeNode t2 = Tree.getTree(nodes2);
        System.out.println("t2 is subtree of t1 : " + obj.checkSubtree(t1, t2));
        int nodes3[] = {4, 2, 9};
        t2 = Tree.getTree(nodes3);
        System.out.println("t2 is subtree of t1 : " + obj.checkSubtree(t1, t2));
    }

    private boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        preOrderTraversal(t1, s1);
        preOrderTraversal(t2, s2);

        if (s1.toString().contains(s2.toString())) {
            return true;
        }

        return false;
    }

    private void preOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("X");
            return;
        }

        int data = node.value;
        result.append(data);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);

    }

}
