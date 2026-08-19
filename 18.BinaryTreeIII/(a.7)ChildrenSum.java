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

// Children Sum Property / Change Tree

class Solution {

    public void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }

        int child = 0;

        if (root.left != null) {
            child += root.left.val;
        }

        if (root.right != null) {
            child += root.right.val;
        }

        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;

        if (root.left != null) {
            tot += root.left.val;
        }

        if (root.right != null) {
            tot += root.right.val;
        }

        if (root.left != null && root.right != null) {
            root.val = tot;
        }
    }
}