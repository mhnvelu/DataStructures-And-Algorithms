package com.dsa.tree;

/*
Problem : Find the Lowest Common Ancestor for given nodes n1 and n2
 */

/*
Solution:
1. Create a recursive function that takes a node and the two values n1 and n2.
2. If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function
for thr right subtree.
3. If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive
function for thr left subtree.
4. If both the above cases are false then return the current node as LCA.

It takes O(h) time and O(h) space
 */
public class LCAInBST {

    public static void main(String a[]) {
        int nodes[] = {20, 8, 25, 4, 12, 22, 26};
        TreeNode root = Tree.getTree(nodes);
        TreeTraversal.inOrderTraversal(root);

        LCAInBST obj = new LCAInBST();
        TreeNode lcaNode = obj.lca(root, new TreeNode(4), new TreeNode(12));
        System.out.println("LCA : " + lcaNode.value);
    }

    private TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return null;
        }
        if (root.value > n1.value && root.value > n2.value) {
            return lca(root.left, n1, n2);
        }

        if (root.value < n1.value && root.value < n2.value) {
            return lca(root.right, n1, n2);
        }

        return root;

    }
}
