/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        return inOrder(root, count, k);
    }

    public int inOrder(TreeNode root, int[] cnt, int k) {
        if (root == null) return -1;

        int left = inOrder(root.left, cnt, k);
        if (left != -1) return left;

        cnt[0]++;
        if (cnt[0] == k) return root.val;

        return inOrder(root.right, cnt, k);
    }
}