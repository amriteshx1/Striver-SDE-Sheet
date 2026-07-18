class Solution {
    public int findMedian(int[][] matrix) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (m * n) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            int smallEqual = countSmallEqual(matrix, m, n, mid);

            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int count = 0;

        for (int i = 0; i < m; i++) {
            count += upperBound(matrix[i], x, n);
        }

        return count;
    }

    private int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}