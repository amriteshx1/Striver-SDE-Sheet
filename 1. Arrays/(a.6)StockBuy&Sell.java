// Optimal

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int profit = 0;
        int minSeenSoFar = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            minSeenSoFar = Math.min(prices[i], minSeenSoFar);
            profit = prices[i] - minSeenSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}