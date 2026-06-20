// Brute
class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1000000){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void markRow(int[][] matrix, int i){
        for(int a = 0; a < matrix[0].length; a++){
            if(matrix[i][a] != 0){
                matrix[i][a] = 1000000;
            }
        }
    }

    private void markCol(int[][] matrix, int j){
        for(int a = 0; a < matrix.length; a++){
            if(matrix[a][j] != 0){
                matrix[a][j] = 1000000;
            }
        }
    }
}

// Better
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if((row[i] == 1) || (col[j] == 1)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// Optimal
class Solution {
    public void setZeroes(int[][] matrix) {
        // int[] row = new int[matrix.length]; matrix[...][0]
        // int[] col = new int[matrix[0].length]; matrix[0][...]
        int col0 = 1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}