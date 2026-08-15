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
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        dfs(root, path, result);
        return result;
    }

    void dfs(TreeNode root, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        // add current node
        path.add(root.data);

        // if leaf node → store path
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path, result);
            dfs(root.right, path, result);
        }

        // backtrack
        path.remove(path.size() - 1);
    }
}