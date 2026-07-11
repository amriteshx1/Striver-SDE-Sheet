// Brute

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp)) return temp;
            set.add(temp);
            temp = temp.next;
        }

        return null;
    }
}

// Optimal (Floyd's Cycle Detection Algorithm using the tortoise and hare technique, like whenever there's a cycle then take slow pointer to head and move both slow and fast by 1 step, they will meet at the starting point of the cycle)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}