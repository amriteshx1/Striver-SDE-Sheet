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