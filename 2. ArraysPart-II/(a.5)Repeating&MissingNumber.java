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


// Optimal Approach

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;
        long sN = n * (n + 1) / 2;
        long s2N = (n * (n + 1) * (2 * n + 1)) / 6;
        long s = 0;
        long s2 = 0;

        for(int i = 0 ; i < nums.length; i++){
            s += (long)nums[i];
            s2 += (long)nums[i] * (long)nums[i];
        }

        long val1 = s - sN;   // x - y
        long val2 = s2 - s2N; // x^2 - y ^2 -> (x + y)(x - y)

        val2 = val2 / val1;  // x + y
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int)x , (int)y};
    }
}