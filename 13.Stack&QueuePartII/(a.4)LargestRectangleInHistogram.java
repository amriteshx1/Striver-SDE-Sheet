// optimal solution using monotonic stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int el = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(heights[el] * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int el = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(heights[el] * (nse - pse - 1), maxArea);
        }

        return maxArea;
    }
}