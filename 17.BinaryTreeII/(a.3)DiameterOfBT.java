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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maxHeight(root, diameter);
        return diameter[0];
    }

    int maxHeight(TreeNode root, int[] diameter){
        if(root == null) return 0;

        int lh = maxHeight(root.left, diameter);
        int rh = maxHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(rh, lh);

    }
}