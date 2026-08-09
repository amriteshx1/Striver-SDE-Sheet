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

// Optimal

class Solution {
    public int celebrity(int[][] M) {
      int n = M.length;
      int top = 0;
      int down = n - 1;

      while(top < down){
        if(M[top][down] == 1){
            top++;
        }else if(M[down][top] == 1){
            down--;
        } else{
            top++;
            down--;
        }
      }

      if(top > down) return -1;

      for(int i = 0; i < n; i++){ // going forward from here you could use top/down any as top == down now
        if(i == top) continue;

        if(M[top][i] == 0 && M[i][top] == 1){
            continue;
        }else{
            return -1;
        }
      }

      return top;
    }
}