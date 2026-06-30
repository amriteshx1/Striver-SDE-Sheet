// Optimal

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int longest = 1;

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        for(int num : set){
            if(set.contains(num - 1)){
                continue;
            }
            int sum = num;
            int cnt = 1;
            while(set.contains(sum + 1)){
                cnt++;
                sum += 1;
            }
            longest = Math.max(longest, cnt);
        }

         return longest;
    }
}