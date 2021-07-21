package com.dsa.tree;

/*
Problem : Find the Lowest Common Ancestor for given nodes n1 and n2
 */

/*
Solution 1:
 */
public class LCAInBT {

    boolean n1Visited, n2Visited = false;

    public static void main(String a[]) {
        LCAInBT obj = new LCAInBT();
        int nodes[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode root = Tree.getTree(nodes);
        TreeTraversal.inOrderTraversal(root);
        System.out.println();
        System.out.println("LCAInBT : " + obj.lcaInBT(root, 1, 9));
    }

    private TreeNode lcaInBTUtil(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        TreeNode temp = null;
        if (root.value == n1) {
            n1Visited = true;
            temp = root;
        }

        if (root.value == n2) {
            n2Visited = true;
            temp = root;
        }

        TreeNode left = lcaInBTUtil(root.left, n1, n2);
        TreeNode right = lcaInBTUtil(root.right, n1, n2);

        if (temp != null) {
            return temp;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private TreeNode lcaInBT(TreeNode root, int n1, int n2) {
        TreeNode lcaNode = lcaInBTUtil(root, n1, n2);
        if (n1Visited && n2Visited) {
            return lcaNode;
        }
        return null;
    }
}
