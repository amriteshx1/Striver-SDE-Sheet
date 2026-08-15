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

    class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair it = q.remove();
            int hd = it.hd;
            TreeNode temp = it.node;

            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }

            if(temp.left != null){
                q.add(new Pair(temp.left, hd - 1));
            }

            if(temp.right != null){
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}