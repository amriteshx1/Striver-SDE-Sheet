// Optimal

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null ) return head;

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){
            ListNode kth = findKthElement(temp, k);
            if(kth == null){
                if(prev != null) prev.next = temp;
                break;
            }

            ListNode nextNode = kth.next;
            kth.next = null;

            reverseLL(temp);
            if(temp == head){
                head = kth;
            }else{
                prev.next = kth;
            }

            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    private ListNode findKthElement(ListNode temp, int k){
        k -= 1;

        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;

        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}