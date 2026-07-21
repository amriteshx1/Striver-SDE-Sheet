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

// Better way - Instead of additional space of new array, we can use 2 pointers to find the median. We can keep track of the count of elements we have seen so far and when we reach the middle element(s), we can return the median.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int first = (total - 1) / 2;
        int second = total / 2;

        int temp1 = 0;
        int temp2 = 0;
        int count = 0;

        int firstElement = 0;
        int secondElement = 0;

        while (temp1 < m && temp2 < n) {
            int current;

            if (nums1[temp1] <= nums2[temp2]) {
                current = nums1[temp1];
                temp1++;
            } else {
                current = nums2[temp2];
                temp2++;
            }

            if (count == first) firstElement = current;
            if (count == second) secondElement = current;

            count++;
        }

        while (temp1 < m) {
            int current = nums1[temp1];
            if (count == first) firstElement = current;
            if (count == second) secondElement = current;
            temp1++;
            count++;
        }

        while (temp2 < n) {
            int current = nums2[temp2];
            if (count == first) firstElement = current;
            if (count == second) secondElement = current;
            temp2++;
            count++;
        }

        if (total % 2 == 1) {
            return firstElement;
        } else {
            return (double) (firstElement + secondElement) / 2;
        }
    }
}

// Optimal

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;

        while(low <= high){
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 1) return (double) Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }else if( l1 > r2) {
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }
}