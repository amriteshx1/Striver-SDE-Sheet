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

// iterative way

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(true){
            if(node != null){
                stack.add(node);
                node = node.left;
            }else{
                if(stack.isEmpty()) break;

                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }
}

// recursive way

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        infn(root, in);
        return in;
    }

    private void infn(TreeNode root, List<Integer> in){
        if(root == null) return;

        infn(root.left, in);
        in.add(root.val);
        infn(root.right, in);
    }
}