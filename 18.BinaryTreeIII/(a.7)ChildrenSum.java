// class TreeNode {
//     int val;
//     TreeNode left, right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    boolean checkChildrenSum(TreeNode root) { 
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int left = (root.left != null) ? root.left.val : 0;
        int right = (root.right != null) ? root.right.val : 0;

        // Check current node + recurse
        if (root.val == left + right &&
            checkChildrenSum(root.left) &&
            checkChildrenSum(root.right)) {
            return true;
        }

        return false;
    }
}

