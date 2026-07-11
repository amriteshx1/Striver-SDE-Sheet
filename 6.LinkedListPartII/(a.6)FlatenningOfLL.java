// Brute (store all inside an arraylist -> sort them -> create a new LL)

/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while(temp != null){
            ListNode t2 = temp;

            while(t2 != null){
                list.add(t2.val);
                t2 = t2.child;
            }
            temp = temp.next;
        }

        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;

        for(int i = 0; i < list.size(); i++){
            next.child = new ListNode(list.get(i));
            next.next = null;
            next = next.child;
        }

        return dummy.child;
    }
}

//  Optimal (using the logic of merging 2 sorted LLs recursively)
class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode nextHead = flattenLinkedList(head.next);
        return mergeTwoLists(head, nextHead);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.child = list1;
                curr = list1;
                list1 = list1.child;
            }else{
                curr.child = list2;
                curr = list2;
                list2 = list2.child;
            }
            curr.next = null;
        }

        if (list1 != null)
            curr.child = list1;
        else
            curr.child = list2;

        return dummy.child;
    }
}