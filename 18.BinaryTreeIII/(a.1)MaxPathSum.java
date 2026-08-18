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
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxSum(root, maxValue);
        return maxValue[0];
    }

    int maxSum(TreeNode root, int[] maxValue){
        if(root == null) return 0;

        int lh = Math.max(0, maxSum(root.left, maxValue));
        int rh = Math.max(0, maxSum(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], root.data + rh + lh);

        return root.data + Math.max(lh, rh);
    }
}