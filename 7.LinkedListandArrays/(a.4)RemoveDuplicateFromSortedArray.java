// Brute is to put all the elements in a set and then replace the original array with the elements in the set. This will take O(n) time and O(n) space.

// Optimal using two pointers. One pointer will keep track of the unique elements and the other pointer will traverse the array. Whenever we find a new unique element, we will place it in the position of the unique pointer and increment the unique pointer. This will take O(n) time and O(1) space.

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i++;
            }
        }

        return i + 1;
    }
}