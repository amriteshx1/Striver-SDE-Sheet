// Optimal solution is to use Dutch National Flag Algorithm which uses 3 pointers low, mid and high.

// Brute

// -> Use any sorting algorithm like merge sort etc. to sort the array and then return the sorted array.

// Better

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                cnt0++;
            } else if (nums[i] == 1){
                cnt1++;
            }else{
                cnt2++;
            }
        }

        for(int i = 0; i < cnt0; i++){
            nums[i] = 0;
        }

        for(int i = cnt0; i < cnt0 + cnt1; i++){
            nums[i] = 1;
        }

        for(int i = cnt0 + cnt1; i < n; i++){
            nums[i] = 2;
        }
    }
}

// Optimal

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}