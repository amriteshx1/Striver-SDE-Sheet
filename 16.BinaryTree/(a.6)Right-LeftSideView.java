// right one

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        recursiveRSV(root, 0, list);
        return list;
    }

    private void recursiveRSV(TreeNode node, int level, List<Integer> list){
        if(node == null) return;

        if(level == list.size()){
            list.add(node.val);
        }

        recursiveRSV(node.right, level + 1, list);
        recursiveRSV(node.left, level + 1, list);
    }
}

// left one (just a one line swap)