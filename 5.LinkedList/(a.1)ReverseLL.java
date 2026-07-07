// Brute

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;
        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }

        ListNode newHead = st.pop();
        temp = newHead;

        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }

        temp.next = null;

        return newHead;

    }
}