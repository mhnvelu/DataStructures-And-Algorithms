package com.dsa.tree;

public class TreeNode {
    public int leftSize = 0;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    // BST tree insertion
    public void insert(int d) {
        if (d <= value) {
            if (left != null) {
                left.insert(d);
            } else {
                TreeNode node = new TreeNode(d);
                left = node;
            }
            // increment only for left subtrees
            leftSize++;

        } else {
            if (right != null) {
                right.insert(d);
            } else {
                right = new TreeNode(d);
            }
        }
    }

    public int getRank(int d) {
        if (d == value) {
            return leftSize;
        } else if (d < value) {
            //left
            if (left == null) {
                return -1;
            }
            return left.getRank(d);
        } else {
            //right
            if (right == null) {
                return -1;
            }
            int rightRank = right.getRank(d);
            if (rightRank == -1) {
                return -1;
            }
            return leftSize + 1 + rightRank;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);

    }
}
