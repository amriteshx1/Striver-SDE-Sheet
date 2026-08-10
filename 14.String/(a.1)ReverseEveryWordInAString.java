// Optimal

class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {

            // skip trailing / extra spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // find the beginning of the current word
            int j = i;

            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // append the current word
            // substring(start, end) -> end is exclusive
            ans.append(s.substring(j + 1, i + 1));

            // skip spaces between words
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // add exactly one space if another word exists
            if (j >= 0) {
                ans.append(' ');
            }

            // move to the previous word
            i = j;
        }

        return ans.toString();
    }
}