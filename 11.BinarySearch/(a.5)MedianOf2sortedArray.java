// Brute way - Have 2 pointers on each array, create a new array. Move the smaller pointer ahead and put that element in the new array. Do this until one of the pointer reaches the end of its array. Then add the remaining elements of the other array to the new array. Finally return the median of the new array.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] arr = new int[m + n];
        int temp1 = 0;
        int temp2 = 0;
        int index = 0;

        while(temp1 < m && temp2 < n){
            if(nums1[temp1] <= nums2[temp2]){
                arr[index] = nums1[temp1];
                temp1++;
                index++;
            }else{
                arr[index] = nums2[temp2];
                temp2++;
                index++;
            }
        }

        while(temp1 < m){
            arr[index] = nums1[temp1];
            temp1++;
            index++;
        }

        while(temp2 < n){
            arr[index] = nums2[temp2];
            temp2++;
            index++;
        }

        if(arr.length % 2 == 1){
            return (double) arr[(arr.length / 2)];
        }else{
            return (double) (arr[(arr.length - 1) / 2] + arr[(arr.length) / 2]) / 2;
        }

    }
}

