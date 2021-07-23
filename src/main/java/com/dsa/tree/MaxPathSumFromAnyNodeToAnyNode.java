package com.dsa.tree;

/*
Problem : Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 */

/*
Solution:

For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
The idea is to keep trace of four paths and pick up the max one in the end.
An important thing to note is, root of every subtree need to return maximum path sum such that at most one child of root is involved.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSumFromAnyNodeToAnyNode {
    public static void main(String a[]) {
        MaxPathSumFromAnyNodeToAnyNode obj = new MaxPathSumFromAnyNodeToAnyNode();
        int nodes1[] = {5, 1, 4, -7, -9, 2, -8};
        TreeNode treeNode = Tree.getTree(nodes1);
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        System.out.println("maxPathSumFromRootToNode : " + obj.findMaxPathSum3(treeNode, result));
        System.out.println("MaxPathSumFromAnyNodeToAnyNode : " + result.get());
    }

    int findMaxPathSum3(TreeNode treeNode, AtomicInteger result) {
        if (treeNode == null) {
            return 0;
        }

        int left = findMaxPathSum3(treeNode.left, result);
        int right = findMaxPathSum3(treeNode.right, result);

        // max path sum from any node to any node
        int max = result.get();
        max = Math.max(max, treeNode.value);
        max = Math.max(max, treeNode.value + left);
        max = Math.max(max, treeNode.value + right);
        max = Math.max(max, treeNode.value + left + right);

        result.set(max);

        // returns the max path sum from root to leaf
        int maxPathSumFromNode = Math.max(treeNode.value, treeNode.value + Math.max(left, right));
        return maxPathSumFromNode;
    }
}
