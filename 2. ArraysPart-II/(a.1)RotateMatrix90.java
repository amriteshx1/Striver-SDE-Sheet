// Brute

class Solution {
    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                temp[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}

// Optimal

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < matrix.length - 1; i++){
            for(int j = i + 1; j < matrix[0].length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        reverse(matrix);
    }

    private int[][] reverse(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            int left = 0;
            int right = matrix[0].length - 1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
        return matrix;
    } 
}