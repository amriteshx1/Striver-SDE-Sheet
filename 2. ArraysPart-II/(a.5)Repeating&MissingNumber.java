// Brute Approach

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

// Better Approach

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = {-1, -1};
        int[] arr2 = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr2[nums[i]]++;
        }

        for(int i = 1; i <= n; i++){
            if(arr2[i] == 2) arr[0] = i;
            else if(arr2[i] == 0) arr[1] = i;

            if(arr[0] != -1 && arr[1] != -1){
                break;
            }
        }

        return arr;
    }
}
