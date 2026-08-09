// Brute

class Solution {
    public int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int nums = Integer.MAX_VALUE;
                for(int k = j; k < j + (i + 1); k++){
                    nums = Math.min(nums, arr[k]);
                }
                a[i] = Math.max(a[i], nums);
            }
        }

        return a;
    }
}

// Better

class Solution {
    public int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && arr[left] >= arr[i]) {
                left--;
            }

            while (right < n && arr[right] >= arr[i]) {
                right++;
            }

            int len = right - left - 1;

            for (int j = 0; j < len; j++) {
                a[j] = Math.max(a[j], arr[i]);
            }
        }

        return a;
    }
}

// Optimal
class Solution {

    public int[] maxOfMin(int[] arr) {
        int n = arr.length;

        int[] prevSmaller = getPreviousSmaller(arr);
        int[] nextSmaller = getNextSmaller(arr);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int windowSize = nextSmaller[i] - prevSmaller[i] - 1;
            ans[windowSize - 1] = Math.max(ans[windowSize - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return ans;
    }

    private int[] getPreviousSmaller(int[] arr) {
        int n = arr.length;
        int[] prevSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = st.peek();
            }

            st.push(i);
        }

        return prevSmaller;
    }

    private int[] getNextSmaller(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = st.peek();
            }

            st.push(i);
        }

        return nextSmaller;
    }
}