class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void insertNodeAfterHead(Node node) {

            Node currentAfterHead = head.next;

            head.next = node;
            node.prev = head;

            node.next = currentAfterHead;
            currentAfterHead.prev = node;

            size++;
        }

        void deleteNode(Node node) {

            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            size--;
        }
    }

    HashMap<Integer, Node> keyToNode;
    HashMap<Integer, DoublyLinkedList> freqToList;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!keyToNode.containsKey(key))
            return -1;

        Node node = keyToNode.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            node.value = value;

            updateFrequency(node);

        } else {

            if (keyToNode.size() == capacity) {

                DoublyLinkedList minFreqList = freqToList.get(minFreq);

                Node nodeToDelete = minFreqList.tail.prev;

                minFreqList.deleteNode(nodeToDelete);

                keyToNode.remove(nodeToDelete.key);
            }

            Node newNode = new Node(key, value);

            keyToNode.put(key, newNode);

            minFreq = 1;

            DoublyLinkedList list = freqToList.getOrDefault(1, new DoublyLinkedList());

            list.insertNodeAfterHead(newNode);

            freqToList.put(1, list);
        }
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqToList.get(oldFreq);

        oldList.deleteNode(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList = freqToList.getOrDefault(node.freq, new DoublyLinkedList());

        newList.insertNodeAfterHead(node);

        freqToList.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */