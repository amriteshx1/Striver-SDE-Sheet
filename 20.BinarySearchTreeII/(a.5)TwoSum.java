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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();

        if (reverse == false) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }

        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);

            if (reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        // normal iterator -> next smallest
        BSTIterator left = new BSTIterator(root, false);

        // reverse iterator -> next largest
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = left.next();
            } else {
                j = right.next();
            }
        }

        return false;
    }
}