// Optimal


class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        int n = Jobs.length;

        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
        int totalProfit = 0;
        int cnt = 0;
        int maxDeadline = -1;

        for(int i = 0; i < n; i++){
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }

        int[] arr = new int[maxDeadline + 1];
        Arrays.fill(arr, -1);

        for(int i = 0; i < n; i++){
            for(int j = Jobs[i][1]; j > 0; j--){
                if(arr[j] == -1){
                    cnt++;
                    arr[j] = Jobs[i][0];
                    totalProfit += Jobs[i][2];
                    break;
                }
            }
        }

        return new int[]{cnt, totalProfit};
    }
}