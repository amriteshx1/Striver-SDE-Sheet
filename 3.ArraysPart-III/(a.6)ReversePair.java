// Better

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > 2 * nums[j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}