// Brute way is to have a dynamic list, add the elements inside that and then traverse backwards till we find the first element greater than the current element. Do this for each element.

// Optimal

class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int index = -1;

    public StockSpanner() {
        st.clear();
    }
    
    public int next(int price) {
        index++;

        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        int ans = index - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price, index});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */