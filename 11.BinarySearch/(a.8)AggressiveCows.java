// Brute linear way

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 1;
        int high = nums[n - 1] - nums[0];

        for(int i = low; i <= high; i++){
            if(canWePlace(nums, i, k) == true){
                continue;
            }else{
                return i - 1;
            }
        }

        return high;
    }

    private boolean canWePlace(int[] nums, int dist, int cows){
        int cntCows = 1;
        int last = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - last >= dist){
                cntCows++;
                last = nums[i];
            }

            if(cntCows >= cows) return true;
        }

        return false;
    }
}


// Binary Search Optimal

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int low = 1;
        int high = nums[n - 1] - nums[0];

        while(low <= high){
            int mid = (low + high) / 2;
            if(canWePlace(nums, mid, k) == true){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canWePlace(int[] nums, int dist, int cows){
        int cntCows = 1;
        int last = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - last >= dist){
                cntCows++;
                last = nums[i];
            }

            if(cntCows >= cows) return true;
        }

        return false;
    }
}
