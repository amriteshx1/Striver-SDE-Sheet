class MinStack {

    Stack<Long> st = new Stack<>();
    long mini;

    public MinStack() {
        
    }
    
    public void push(int value) {
        if (st.isEmpty()) {
            mini = value;
            st.push((long) value);
        } else {
            if(value > mini){
                st.push((long) value);
            }else {
                st.push(2L * value - mini);
                mini = value;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        long n = st.peek();
        st.pop();

        if (n < mini) {
            mini = 2L * mini - n;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;

        long n = st.peek();

        if(n > mini){
            return (int) n;
        }

        return (int) mini;
    }
    
    public int getMin() {
        return (int) mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */