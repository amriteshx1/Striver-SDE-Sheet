// Kadane's Algorithm

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

// Optimal

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(sum, max);

            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}