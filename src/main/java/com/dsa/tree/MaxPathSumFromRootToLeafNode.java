package com.dsa.tree;

/*
Problem: Given a binary tree , return a max value from root-to-leaf path such that adding up all the values
        along the path gives max value.
*/

/*
Solution:
1. Pre-order traversal and at each node calculate running sum
2. Pass the running sum to next recursive call
3. If reached leaf nodes, then return the max. Keep track of max value at each recursion
4. Return the max value

It takes O(n) time
 */
public class MaxPathSumFromRootToLeafNode {
    public static void main(String a[]) {
        MaxPathSumFromRootToLeafNode obj = new MaxPathSumFromRootToLeafNode();
        int nodes1[] = {5, 1, 4, 7, 9, 2, 8};
        TreeNode treeNode = Tree.getTree(nodes1);
        System.out.println("Max PathSum From Root To LeafNode : " + obj.findMaxPathSum(treeNode, 0));
        System.out.println("Max PathSum From Root To LeafNode : " + obj.findMaxPathSum2(treeNode));
    }

    int findMaxPathSum(TreeNode treeNode, int sum) {
        int maxValue = Integer.MIN_VALUE;
        sum = sum + treeNode.value;
        if (sum > maxValue) {
            maxValue = sum;
        }

        if (treeNode.left == null && treeNode.right == null) {
            return maxValue;
        }

        if (treeNode.left != null) {
            int result = findMaxPathSum(treeNode.left, sum);
            maxValue = result > maxValue ? result : maxValue;
        }

        if (treeNode.right != null) {
            int result = findMaxPathSum(treeNode.right, sum);
            maxValue = result > maxValue ? result : maxValue;
        }
        return maxValue;
    }

    int findMaxPathSum2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = findMaxPathSum2(treeNode.left);
        int right = findMaxPathSum2(treeNode.right);
        int result = Math.max(treeNode.value, treeNode.value + Math.max(left, right));
        return result;
    }
}
