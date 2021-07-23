package com.dsa.tree;

/*
Problem:
Given Trees T1 and T2, check if they are mirror
 */

/*
Solution:
1. If root nodes from t1 and t2 have same value, then perform matchMirrorTrees starting from that node in both trees. else
return false
1.1. Perform matchMirrorTrees recursively till all nodes matches in both subtrees
1.2. Return false any nodes mismatch while traversing

 */

public class CheckTreesAreMirror {

    public static void main(String a[]) {
        CheckTreesAreMirror obj = new CheckTreesAreMirror();
        int nodes1[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode t1 = Tree.getTree(nodes1);
        int nodes2[] = {5, 4, 1, 8, 2, 9, 7};
        TreeNode t2 = Tree.getTree(nodes2);
        System.out.println("t2 is mirror of t1 : " + obj.checkMirror(t1, t2));
    }

    private boolean checkMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t1.value == t2.value) {
            return matchMirrorTrees(t1, t2);
        } else {
            return false;
        }
    }

    private boolean matchMirrorTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.value == t2.value) {
            return (matchMirrorTrees(t1.left, t2.right) && matchMirrorTrees(t1.right, t2.left));
        } else {
            return false;
        }
    }
}
