// Optimal (do understand the code please again)

class Solution {
    public List<Integer> search(String pat, String txt) {
        int n = txt.length();
        List<Integer> list = new ArrayList<>();
        
        int[] lps = buildLPS(pat);
        int index = 0;

        for(int i = 0; i < n; i++){
            if(txt.charAt(i) == pat.charAt(index)){
                index++;

                if(index == pat.length()){
                    list.add(i - index + 1);

                    index = lps[index - 1];
                }
            }else{
                if(index > 0){
                    index = lps[index - 1];
                    i--;
                }
            }
        }
        
        return list;
    }

    private int[] buildLPS(String pattern) {
      int n = pattern.length();
      int[] lps = new int[n];
  
      int len = 0;
      int i = 1;
  
      while (i < n) {
  
          if (pattern.charAt(i) == pattern.charAt(len)) {
              len++;
              lps[i] = len;
              i++;
          } 
          else {
              if (len > 0) {
                  len = lps[len - 1];
              } 
              else {
                  lps[i] = 0;
                  i++;
              }
          }
      }
  
      return lps;
    }
}
