// Brute

class Solution {
    public int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int nums = Integer.MAX_VALUE;
                for(int k = j; k < j + (i + 1); k++){
                    nums = Math.min(nums, arr[k]);
                }
                a[i] = Math.max(a[i], nums);
            }
        }

        return a;
    }
}