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
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();

        int[] count = new int[1];
        ans.add(kthSmallest(root, k, count));

        count[0] = 0;
        ans.add(kthLargest(root, k, count));

        return ans;
    }

    private int kthSmallest(TreeNode root, int k, int[] count) {
        if (root == null) return -1;

        int left = kthSmallest(root.left, k, count);
        if (left != -1) return left;

        count[0]++;
        if (count[0] == k) return root.data;

        return kthSmallest(root.right, k, count);
    }

    private int kthLargest(TreeNode root, int k, int[] count) {
        if (root == null) return -1;

        int right = kthLargest(root.right, k, count);
        if (right != -1) return right;

        count[0]++;
        if (count[0] == k) return root.data;

        return kthLargest(root.left, k, count);
    }
}