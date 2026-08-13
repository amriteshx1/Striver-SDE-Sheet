// It's just a one line change in the solution of Inorder one, instead of adding the value of the node after reaching the leftmost node, we add it before going to the left subtree. This is because in preorder traversal, we visit the root first, then the left subtree, and finally the right subtree.

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                } else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return list;
    }
}