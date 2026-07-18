// Optimal (thoda points wgera ka dekh lena)

class Solution {
    public int NthRoot(int N, int M) {
        return getNthRoot(N, M);
    }

    private int getNthRoot(int N, int M){
        double low = 1;
        double high = M;

        double eps = 1e-6;

        while((high - low) > eps){

            double mid = (low + high) / 2.0;
            if(multiply(mid, N) < M){
                low = mid;
            }else{
                high = mid;
            }
        }

        int ans = (int)Math.round(low);

        if (multiply(ans, N) == M)
            return ans;

        return -1;
    }

    private double multiply(double num, int n ){
        double ans = 1.0;
        for(int i = 0; i < n; i++){
            ans = ans * num;
        }

        return ans;
    }
}
