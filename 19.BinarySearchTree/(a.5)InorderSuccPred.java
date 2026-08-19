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
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        int successor = -1;
        int predecessor = -1;

        while (root != null) {
            if (key > root.data) {
                predecessor = root.data;
                root = root.right;

            } else if (key < root.data) {
                successor = root.data;
                root = root.left;

            } else {
                // key == root.data

                // Predecessor = rightmost node in left subtree
                if (root.left != null) {
                    TreeNode temp = root.left;

                    while (temp.right != null) {
                        temp = temp.right;
                    }

                    predecessor = temp.data;
                }

                // Successor = leftmost node in right subtree
                if (root.right != null) {
                    TreeNode temp = root.right;

                    while (temp.left != null) {
                        temp = temp.left;
                    }

                    successor = temp.data;
                }

                break;
            }
        }

        list.add(predecessor);
        list.add(successor);

        return list;
    }
}