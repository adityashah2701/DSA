class Solution {
    public int helper(int i, int buy, int cap, int[] prices, int n, Integer dp[][][]) {
        if (cap == 0)
            return 0;
        if (i == n)
            return 0;
        int profit = 0;
        if (dp[i][buy][cap] != null)
            return dp[i][buy][cap];
        if (buy == 1) {
            profit = Math.max(-prices[i] + helper(i + 1, 0, cap, prices, n, dp),
                    0 + helper(i + 1, 1, cap, prices, n, dp));
        } else {
            profit = Math.max(prices[i] + helper(i + 1, 1, cap - 1, prices, n, dp),
                    0 + helper(i + 1, 0, cap, prices, n, dp));
        }

        return dp[i][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return helper(0,1,2,prices,n,dp);
    }
}