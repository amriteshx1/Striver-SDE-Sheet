// Not brute but neither optimal, but better than brute force

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] suffix = new int[n];
        suffix[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        int total = 0;
        int largestSeen = 0;

        for(int i = 0; i < n; i++){
            largestSeen = Math.max(height[i], largestSeen);
            if(height[i] < largestSeen && height[i] < suffix[i]){      // this is not needed as the Math.min(largestSeen, suffix[i]) - height[i] will be 0 if the condition is not met
                total += Math.min(largestSeen, suffix[i]) - height[i];
            }
        }

        return total;
    }
}