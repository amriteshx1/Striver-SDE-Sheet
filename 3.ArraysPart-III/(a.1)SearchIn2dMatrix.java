// Brute

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}

// Better (This one's the optimal solution for Leetcode's Search a 2D Matrix II problem)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0){
            if(matrix[i][j] > target){
                j--;
            } else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }

        return false;
    }
}

// Optimal

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (matrix == null || n == 0 || m == 0) {
            return false;
        }

        int low = 0;
        int high = (n * m) - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int value = matrix[mid / m][mid % m];

            if(value == target){
                return true;
            } else if(value < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }

        return false;
    }
}