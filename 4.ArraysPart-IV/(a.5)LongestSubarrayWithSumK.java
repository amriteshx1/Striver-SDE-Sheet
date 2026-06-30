// Optimal (if array contains +ve as well as -ve)

class Solution {
    public int longestSubarray(int[] nums, int k) {
       int n = nums.length;

       HashMap<Long, Integer> map = new HashMap<>();
       int longest = 0;
       long prefixSum = 0;

       for(int i = 0; i < n; i++){
        prefixSum = prefixSum + nums[i];
        if(prefixSum == k){
            longest = Math.max(longest, i + 1);
        }
        long remaining = prefixSum - k;
        if(map.containsKey(remaining)){
            longest = Math.max(longest, i - map.get(remaining));
        }
        if(!map.containsKey(prefixSum)){
             map.put(prefixSum, i);
        }
       }
       return longest;
    }
}

// another optimal exists using two pointer and trimming approach but that is only applicable for +ve numbers in array.
