// Naive Approach

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n];
        int duplicate = Integer.MIN_VALUE;
        int value = 0;

        for(int i = 0; i < n; i++){
            value = nums[i];
            nums2[value]++;

            if(nums2[value] == 2) duplicate = value;
        }

        return duplicate;
    }
}

// Optimal without extra space

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast){
          slow = nums[slow];
          fast = nums[fast];
        }

        return slow;
    }
}