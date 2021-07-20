package com.dsa.tree;

public class TreeIsBST {
    Integer lastValue = null;

    public static void main(String a[]) {
        TreeIsBST obj = new TreeIsBST();
        int bstNodes[] = {10, 6, 12, 5, 9, 11, 14};
        TreeNode root = Tree.getTree(bstNodes);
        System.out.println("isBST : " + obj.isBST(root));
        int nonBstNodes[] = {5, 9, 4, 7, 9, 2, 8};
        root = Tree.getTree(nonBstNodes);
        System.out.println("isBST : " + obj.isBST(root));
    }

    private boolean isBST(TreeNode root) {
        return checkBST(root);
    }

    private boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!checkBST(root.left)) {
            return false;
        }

        if (lastValue != null && root.value < lastValue) {
            return false;
        }
        lastValue = root.value;

        if (!checkBST(root.right)) {
            return false;
        }

        return true;
    }

}
