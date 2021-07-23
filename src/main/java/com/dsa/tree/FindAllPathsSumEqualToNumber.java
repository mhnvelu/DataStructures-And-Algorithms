package com.dsa.tree;
/*
Problem: Print number paths in a tree equal to given number.
The path does not need to start or end at the root or leaves
 */
/*
Solution:
1. Get running sum for each node
2. Calculate runningSum - targetSum, check if the result is available in HashMap(key:runningSum, value: count) and assign to
totalPath
3. Check the runningSum == targetSum. If yes, increment totalPath
4. Increment the value for runningSum in the HashMap
6. recurse on left subtree
7. recurse on right subtree
8. Decrement the value for runningSum in the HashMap

It takes O(n) time, o(logn) space for balanced tree, O(n) space for unbalanced tree
 */

import java.util.HashMap;

public class FindAllPathsSumEqualToNumber {
    public static void main(String a[]) {
        FindAllPathsSumEqualToNumber obj = new FindAllPathsSumEqualToNumber();
        int nodes1[] = {5, 1, 4, 7, 10, 2, 8};
        TreeNode treeNode = Tree.getTree(nodes1);
        System.out.println("Number of paths for sum 6 : " + obj.findAllPaths(treeNode, new HashMap<Integer, Integer>(), 0, 11));

    }

    private int findAllPaths(TreeNode treeNode, HashMap<Integer, Integer> pathCount, int runningSum, int targetSum) {
        if (treeNode == null) {
            return 0;
        }

        runningSum += treeNode.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.get(sum) == null ? 0 : pathCount.get(sum);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementPathCount(pathCount, runningSum, 1);
        totalPaths += findAllPaths(treeNode.left, pathCount, runningSum, targetSum);
        totalPaths += findAllPaths(treeNode.right, pathCount, runningSum, targetSum);
        incrementPathCount(pathCount, runningSum, -1);

        return totalPaths;

    }

    private void incrementPathCount(HashMap<Integer, Integer> pathCount, int runningSum, int value) {
        int newCount = pathCount.get(runningSum) == null ? value : pathCount.get(runningSum) + value;
        if (newCount == 0) {
            pathCount.remove(runningSum);
        } else {
            pathCount.put(runningSum, newCount);
        }
    }

}
