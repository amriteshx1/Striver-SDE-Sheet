/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class NodeValue {
    int maxNode;
    int minNode;
    int maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

class Solution {

    private NodeValue helper(TreeNode root) {

        // empty subtree
        if (root == null) {
            return new NodeValue(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // current subtree is a BST
        if (left.maxNode < root.data && root.data < right.minNode) {

            return new NodeValue(
                Math.min(root.data, left.minNode),
                Math.max(root.data, right.maxNode),
                left.maxSize + right.maxSize + 1
            );
        }

        // current subtree is not a BST
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }

    public int largestBST(TreeNode root) {
        return helper(root).maxSize;
    }
}