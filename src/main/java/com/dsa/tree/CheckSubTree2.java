package com.dsa.tree;

/*
Problem : T1 and T2 are the 2 large binary tress, with t1 much bigger than T2. Write an algorithm
to determine if T2 is a subtree of T1
 */

/*
Solution:
1. If 2 nodes from t1 and t2 have same value, then perform matchTrees starting from that node in both trees.
1.1. Perform this recursively till all nodes matches in both subtrees
1.2. Return false any nodes mismatch while traversing
2. If 2 nodes from t1 and t2 don't same value, then perform pre-order traversal

It takes O(m + kn) time. k is number of times root node in t2 matches with t1.
Its better optimized than solution in CheckSubTree1 class
 */
public class CheckSubTree2 {
    public static void main(String a[]) {
        CheckSubTree2 obj = new CheckSubTree2();
        int nodes1[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode t1 = Tree.getTree(nodes1);
        int nodes2[] = {4, 2, 8};
        TreeNode t2 = Tree.getTree(nodes2);
        System.out.println("t2 is subtree of t1 : " + obj.subtree(t1, t2));
        int nodes3[] = {4, 2, 9};
        t2 = Tree.getTree(nodes3);
        System.out.println("t2 is subtree of t1 : " + obj.subtree(t1, t2));
    }

    private boolean subtree(TreeNode t1, TreeNode t2) {
        if (t1 == null) { // empty tree t2 is subtree of t1
            return false;
        } else if (t1.value == t2.value) {
            return matchTree(t1, t2);
        }

        boolean left = subtree(t1.left, t2);
        boolean right = subtree(t1.right, t2);

        return left || right;
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.value == t2.value) {
            return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
        } else {
            return false;
        }
    }
}
