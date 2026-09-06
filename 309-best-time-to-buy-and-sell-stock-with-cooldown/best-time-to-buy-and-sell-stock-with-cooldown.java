class Solution {

    public int helper(int i, int buy, int[] prices, int n, Integer[][] dp) {

        if (i >= n)
            return 0;

        if (dp[i][buy] != null)
            return dp[i][buy];

        int profit;

        if (buy == 1) {
            profit = Math.max(
                    -prices[i] + helper(i + 1, 0, prices, n, dp),
                    helper(i + 1, 1, prices, n, dp));
        } else {
            profit = Math.max(
                    prices[i] + helper(i + 2, 1, prices, n, dp),
                    helper(i + 1, 0, prices, n, dp));
        }

        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            dp[i][1] = Math.max(
                    -prices[i] + dp[i + 1][0],
                    dp[i + 1][1]);

            dp[i][0] = Math.max(
                    prices[i] + dp[i + 2][1],
                    dp[i + 1][0]);

        }

        return dp[0][1];
    }
}