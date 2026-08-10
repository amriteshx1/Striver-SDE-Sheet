// Optimal

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while(i >= 0){
            // remove trailing spaces
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0) break;

            int j = i;

            // get the first word end
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }

            // jaise hi first whitespace mile, ruk jaa append from j + 1 to i + 1 (ii + 1 is exclusive though by default)
            ans.append(s.substring(j + 1, i + 1));

            // remove in between extra spaces
            while(j >= 0 && s.charAt(j) == ' '){
                j--;
            }

            // if j < 0 means first word pe tha mai
            // else we need to add single space after the word
            if(j >= 0){
                ans.append(' ');
            }

            // place i at the index of j for future word iterations
            i = j;
        }

        return ans.toString();
    }
}