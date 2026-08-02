// ask gpt while revision of how we first popping elements out making it empty and then inserting them back in sorted order. The insert function is a recursive function that places the popped element in the correct position in the stack.

class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.empty()){
            return;
        }

        int num = st.pop();

        sortStack(st);

        insert(st, num);
    }

    public void insert(Stack<Integer> st, int num){
        if(st.empty() || num >= st.peek()){
            st.push(num);
            return;
        }

        int top = st.pop();

        insert(st, num);

        st.push(top);
    }
}