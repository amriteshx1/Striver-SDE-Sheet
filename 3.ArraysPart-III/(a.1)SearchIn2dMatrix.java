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

// Better

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
