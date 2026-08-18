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
    public List<Integer> boundary(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        if (!isLeaf(root)) list.add(root.data);

        addLeftNodes(root, list);
        addLeaf(root, list);
        addRightNodes(root, list);

        return list;
    }

    boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    void addLeftNodes(TreeNode node, List<Integer> list) {
        TreeNode cur = node.left;

        while (cur != null) {
            if (!isLeaf(cur)) list.add(cur.data);

            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    void addRightNodes(TreeNode node, List<Integer> list) {
        TreeNode cur = node.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (cur != null) {
            if (!isLeaf(cur)) temp.add(cur.data);

            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        int i;

        for (i = temp.size() - 1; i >= 0; i--) {
            list.add(temp.get(i));
        }
    }

    void addLeaf(TreeNode node, List<Integer> list) {
        if (isLeaf(node)) {
            list.add(node.data);
            return;
        }

        if (node.left != null) addLeaf(node.left, list);
        if (node.right != null) addLeaf(node.right, list);
    }
}