// Naive Approach

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2];

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i == nums[j]){
                    cnt++;
                }
            }
            if(cnt == 2) arr[0] = i;
            else if(cnt == 0) arr[1] = i;
        }

        return arr;
    }
}


