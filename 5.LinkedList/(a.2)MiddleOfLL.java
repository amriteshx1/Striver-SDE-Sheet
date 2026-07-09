// self - made optimal using slow & fast i.e. tortoise and hare approach

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

// Brute (first finding length and then traversing to mid)

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        int length = 0;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        int mid = (length / 2) + 1;
        temp = head;

        while(temp != null){
            mid--;
            if(mid == 0){
                break;
            }

            temp = temp.next;
        }

        return temp;
    }
}