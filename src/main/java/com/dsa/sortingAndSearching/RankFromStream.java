package com.dsa.sortingAndSearching;

/*
Problem: Imagine reading in a stream of integers and lookup the rank of a number x (the number of values <= x).
Implement Data structure and algorithm to get rank of a number
 */

import com.dsa.tree.TreeNode;

/*
Solution:
1. Implement BST which tracks of number of elements on the left subtree of a node
2. Perform pre-order traversal conditionally
3. It takes o(log n) on a balanced tree and o(n) on an unbalanced tree
 */
public class RankFromStream {

    private TreeNode root = null;

    public static void main(String a[]) {
        RankFromStream rankFromStream = new RankFromStream();
        rankFromStream.track(20);
        rankFromStream.track(15);
        rankFromStream.track(25);
        rankFromStream.track(10);
        rankFromStream.track(23);
        rankFromStream.track(24);
        rankFromStream.track(5);
        rankFromStream.track(14);
        System.out.println("Rank of 24 is : " + rankFromStream.getRank(24));
    }

    public void track(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            root.insert(d);
        }
    }

    public int getRank(int d) {
        return root.getRank(d);
    }
}
