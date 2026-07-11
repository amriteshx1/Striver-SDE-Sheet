// Using stack 

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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            if(temp.val != st.pop()){
                return false;
            }

            temp = temp.next;
        }

        return true;
    }
}

// Optimal (first finding mid and then reversing the second half and then comparing both halves)

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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next;
        ListNode newHead = reverseLL(slow);
        ListNode temp = newHead;

        while(temp != null){
            if (head.val != temp.val) {
                reverseLL(newHead); // just for interview touch
                return false;
            }
            head = head.next;
            temp = temp.next;
        }  

        reverseLL(newHead); // same interview touch here as well
        return true;
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