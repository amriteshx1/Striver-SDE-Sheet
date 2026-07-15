// Optimal

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        int i = 0;
        int j = 0;
        int cnt = 0;
        int maxCnt = 0;

        // Arrays.sort(Arrival); Only if the Arrival is not in sorted fashion
        Arrays.sort(Departure);

        while(i < n){
            if(Arrival[i] <= Departure[j]){
                cnt++;
                i++;
            }else{
                cnt--;
                j++;
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt;
    }
}