class Solution {
    public int[] nextLargerElement(int[] arr) {
        int[] num = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){

            while(!st.empty() && arr[i] >= st.peek()){
                st.pop();
            }

            if(st.empty()){
                num[i] = -1;
            }else{
                num[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return num;
    }
}