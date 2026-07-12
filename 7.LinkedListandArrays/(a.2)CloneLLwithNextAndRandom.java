// Brute (create all nodes and store in hashmap and then connect them)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}

// Optimized (without using extra space i.e first create a copy of the node and insert it in between the original nodes and then connect the random pointer and finally separate the two lists)


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node temp = head;

        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            } else{
                copyNode.random = null;
            }
            
            temp = temp.next.next;
        }

        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;

        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}