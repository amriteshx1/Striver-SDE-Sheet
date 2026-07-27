class ArrayQueue {
    int[] arr;
    int front;
    int rear;

    public ArrayQueue() {
        arr = new int[1000];
        front = 0;
        rear = -1;
    }

    public void push(int x) {
        arr[++rear] = x;
    }

    public int pop() {
        return arr[front++];
    }

    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }
}