class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        if (i == n) {
            return 0;
        }

        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        int ans = 0;

        while(i < n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && digit > 7)){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
}