/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}

class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<Pair> st = new Stack<>();

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        st.push(new Pair(root, 1));

        while(!st.empty()){

            Pair it = st.pop();

            // Preorder
            if(it.num == 1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // Inorder
            else if(it.num == 2){
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }
            }

            // Postorder
            else{
                post.add(it.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
}