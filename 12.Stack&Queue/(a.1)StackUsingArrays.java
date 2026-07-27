class ArrayStack {
    int[] arr;
    int top;

    public ArrayStack() {
        arr = new int[1000]; // stack size
        top = -1;
    }

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        return arr[top--];
    }

    public int top() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
