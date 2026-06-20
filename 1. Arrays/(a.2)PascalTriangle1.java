// Optimal NcR approach

class Solution {
    public int pascalTriangleI(int r, int c) {
        long res = 1;

        int s = r - 1;
        int d = c - 1;

        for(long i = 0; i < d; i++){
            res = res * (s - i);
            res = res / (i + 1);
        }
        return (int) res;
    }
}