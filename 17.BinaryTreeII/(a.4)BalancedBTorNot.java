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
    public boolean isBalanced(TreeNode root) {
        return maxHeight(root) != -1;
	}

    int maxHeight(TreeNode root){
        if(root == null) return 0;

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }
}