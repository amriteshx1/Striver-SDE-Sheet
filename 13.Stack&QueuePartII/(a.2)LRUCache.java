class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        deleteNode(node);
        insertNodeAfterHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            node.value = value;

            deleteNode(node);
            insertNodeAfterHead(node);
            
        } else {
            if(map.size() == capacity){
                
                Node node = tail.prev;

                map.remove(node.key);
                deleteNode(node);
            }

            Node node = new Node(key, value);

            map.put(key, node);
            insertNodeAfterHead(node);
        }
    }

    // custom insertNodeAfterHead and delete funtions
    private void insertNodeAfterHead(Node node){
        Node currentAfterNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = currentAfterNode;
        currentAfterNode.prev = node;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */