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

It takes O(n) time, O(n) space
 */
public class ListOfDepthsSolution1 {
    public static void main(String a[]) {
        int nodes[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode root = Tree.getTree(nodes);
        ListOfDepthsSolution1 obj = new ListOfDepthsSolution1();
        System.out.println(obj.createLinkedListLPerLevel(root));

    }

    private List<LinkedList<TreeNode>> createLinkedListLPerLevel(TreeNode treeNode) {
        List<LinkedList<TreeNode>> result = new ArrayList<>();


        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(treeNode);


        while (current.size() > 0) {
            result.add(current); //  // level i-1
            LinkedList<TreeNode> parents = current;  // level i
            current = new LinkedList<>();
            for (TreeNode parent :
                    parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}

