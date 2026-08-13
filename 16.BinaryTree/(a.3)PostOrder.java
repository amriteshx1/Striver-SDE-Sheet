// recursive way

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}

// iterative way

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        if(root == null) return list;

        st1.add(root);

        while(!st1.isEmpty()){
            root = st1.pop();
            st2.add(root);

            if(root.left != null) st1.add(root.left);
            if(root.right != null) st1.add(root.right);
        }

        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }

        return list;
    }
}