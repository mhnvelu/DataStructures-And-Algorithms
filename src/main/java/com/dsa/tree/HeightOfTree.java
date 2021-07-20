package com.dsa.tree;

public class HeightOfTree {
    public static void main(String a[]){
        int nodes[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode root = Tree.getTree(nodes);
        System.out.println("Height of Tree : " + Tree.heightOfTree(root));
    }
}
