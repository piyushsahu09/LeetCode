class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k == 0) {
            return 0;
        }

        // Optimization: If k is large enough, we can make max possible transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // dp[i][j] = max profit using at most i transactions up to day j
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            // maxDiff tracks the maximum of (dp[i-1][m] - prices[m])
            int maxDiff = -prices[0]; 
            
            for (int j = 1; j < n; j++) {
                // Option 1: Do nothing on day j
                // Option 2: Sell on day j
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                
                // Update maxDiff for the next day's potential sale
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}