// Brute

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;

        while(left < m && right < n){
            if(nums1[left] < nums2[right]){
                nums3[index] = nums1[left];
                index++;
                left++;
            }else{
                nums3[index] = nums2[right];
                index++;
                right++;
            }
        }

        while(left < m){
            nums3[index++] = nums1[left++];
        }

        while(right < n){
            nums3[index++] = nums2[right++];
        }

        for(int i = 0; i < m + n; i++){
            nums1[i] = nums3[i];
        }
    }
}

// Optimal (could be better too) 
// lol while revising i found for the leetcode one, the below is not the optimal and if we just copy the elements at last and do arrays.sort at end -> that too gonna have the more or less same complexity man.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        if (n == 0) {
          return;
        }

        if(m == 0){
            while(right < n){
                nums1[right] = nums2[right];
                right++;
            }
            return;
        }


        while(left >= 0 && right < n && nums1[left] > nums2[right]){
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
            left--;
            right++;
        }

        int index = 0;

        for(int i = m; i < m + n; i++){
            nums1[i] = nums2[index];
            index++;
        }

        Arrays.sort(nums1);
    }
}

// Main Optimal (for leetcode one, striver wala dekh lena baad mae kya scene hai)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = m - 1;        // last actual element of nums1
        int right = n - 1;       // last element of nums2
        int index = m + n - 1;   // last position of nums1

        while (left >= 0 && right >= 0) {

            if (nums1[left] > nums2[right]) {
                nums1[index] = nums1[left];
                left--;
            } else {
                nums1[index] = nums2[right];
                right--;
            }

            index--;
        }

        // If nums2 still has elements
        while (right >= 0) {
            nums1[index] = nums2[right];
            right--;
            index--;
        }
    }
}