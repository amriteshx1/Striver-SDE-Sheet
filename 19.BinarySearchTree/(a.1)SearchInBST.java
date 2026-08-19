/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.data == val) return root;

            if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}