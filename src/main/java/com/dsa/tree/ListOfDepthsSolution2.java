package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Problem: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
If the tree has depth D, then the algorithm should produce D linked lists
 */

/*
Solutions : using BFS
With each level i, we will have already fully visited all nodes on level i-1.
This means that to get which nodes are on level i, we can simply look at all children of the nodes of level i-1

It takes O(n) time, O(n) space + O(logN) space for recursive calls
 */

public class ListOfDepthsSolution2 {
    public static void main(String a[]) {
        int nodes[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode root = Tree.getTree(nodes);
        ListOfDepthsSolution2 obj = new ListOfDepthsSolution2();
        System.out.println(obj.createLinkedListLPerLevel(root));
    }

    public List<LinkedList<TreeNode>> createLinkedListLPerLevel(TreeNode treeNode) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        createLinkedListLPerLevel(treeNode, result, 0);
        return result;
    }

    private void createLinkedListLPerLevel(TreeNode root, List<LinkedList<TreeNode>> result, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (result.size() == level) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(root);

        createLinkedListLPerLevel(root.left, result, level + 1);
        createLinkedListLPerLevel(root.right, result, level + 1);

    }
}
