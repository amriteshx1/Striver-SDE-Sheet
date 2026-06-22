// Brute

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int k = j; k < n; k++){
                    sum += nums[k];
                    max = Math.max(sum, max);
                }
            }
        }

        return max;
    }
}

// Better

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
             int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}