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