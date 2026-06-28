// Brute

class Solution {
    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;

        for (long i = 0; i < N; i++) {
            ans *= x;
        }

        return ans;
    }
}

// Optimal

class Solution {
    public double myPow(double x, int n) {

        long N = n;
        double ans = 1;

        if( N < 0){
            x = 1 / x;
            N = -N;
        }
        while(N > 0){
            if(N % 2 == 0){
                x = x * x;
                N = N / 2;
            } else{
                ans = ans * x;
                N = N - 1;
            }
        }

        return ans;
    }
}