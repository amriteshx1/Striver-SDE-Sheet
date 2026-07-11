// Brute

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        HashMap<ListNode, Integer> map = new HashMap<>();

        while(temp1 != null){
            map.put(temp1, 1);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            if(map.containsKey(temp2)){
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }
}

// Better (without extra space)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = 0;
        int len2 = 0;

        while(temp1 != null){
            len1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            len2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if(len1 > len2){
            for(int i = 0; i < len1 - len2; i++){
                temp1 = temp1.next;
            }
        }

        if(len2 > len1){
            for(int i = 0; i < len2 - len1; i++){
                temp2 = temp2.next;
            }
        }

        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }
}

// Optimal (without extra space and without calculating length)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }

        return temp1;
    }
}