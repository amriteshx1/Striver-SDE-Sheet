//Optimal approach

// so first just try to find from back first point/index where nums[i] < nums[i + 1].
// then from last index till that breakpoint, find the first number which is greater than nums[breakpoint] and swap them.
// then reverse the array from breakpoint + 1 to end of array.
// and obviously if the breakpoint remains -1, then reverse the whole array simply.

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        for(int i = n - 1; i > breakPoint; i--){
            if(nums[i] > nums[breakPoint]){
                int temp = nums[breakPoint];
                nums[breakPoint] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, breakPoint + 1, n - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}