// Brute

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int index = 0;

        for(int i = 0; i <= n - k; i++){
            int maxi = nums[i];

            for(int j = i; j <= i + k - 1; j++){
                maxi = Math.max(maxi, nums[j]);
            }
            arr[index] = maxi;
            index++;
        }

        return arr;
    }
}

// Optimal using decreasing monotonic deque

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int index = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k - 1){
                arr[index] = nums[dq.peekFirst()];
                index++;
            }
        } 


        return arr;
    }
}