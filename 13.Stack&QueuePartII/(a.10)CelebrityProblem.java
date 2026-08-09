// Brute

class Solution {
    public int celebrity(int[][] M) {
      int n = M.length;

      for(int i = 0; i < n; i++){
        boolean isCelebrity = true;

        for(int j = 0; j < n; j++){
            if (i == j) continue;
            
            if(M[i][j] == 1 || M[j][i] == 0){
                isCelebrity = false;
                break;
            }
        }

        if(isCelebrity){
            return i;
        }
      }

      return -1;
    }
}