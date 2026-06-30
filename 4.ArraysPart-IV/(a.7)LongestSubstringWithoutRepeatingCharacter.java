// Brute
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            int[] hash = new int[256];
            for(int j = i; j < n; j++){
                if(hash[s.charAt(j)] == 1){
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }

        return maxLen;
    }
}

// Optimal
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while(right < n){
            if(hash[s.charAt(right)] != -1){
                if(hash[s.charAt(right)] >= left){
                    left = hash[s.charAt(right)] + 1;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
            hash[s.charAt(right)] = right;
            right++;
        }

        return maxLen;
    }
}