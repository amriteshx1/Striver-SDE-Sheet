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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        
        int floor = -1;
        int ceil = -1;

        while (root != null) {
            if (root.data == key) {
                floor = key;
                ceil = key;
                break;
            } 
            else if (root.data < key) {
                floor = root.data;
                root = root.right;
            } 
            else {
                ceil = root.data;
                root = root.left;
            }
        }

        list.add(floor);
        list.add(ceil);
        return list;
    }
}