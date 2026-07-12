// Optimal (solved in O(n) time and O(1) space) FIRSTTTTTTT ONEEEEEEE MEDIUM!

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = null;
        ListNode temp = head;
        int cnt = 0;

        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        k %= cnt;                // EDGE CASE THAT GPT GAVE head = [1,2,3],k = 3
        if (k == 0) return head; // THESE TWO LINES ARE JUST TO FIX THAT EDGE CASE

        for(int i = 0; i < k; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}