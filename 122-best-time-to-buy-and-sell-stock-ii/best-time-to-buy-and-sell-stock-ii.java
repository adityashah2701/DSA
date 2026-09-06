class Solution {
    public int helper(int i, int buy, int[] prices, int n,Integer dp[][]) {
        if (i == n)
            return 0;
        int profit = 0;
        if(dp[i][buy] != null) return dp[i][buy];
        if (buy == 1) {
            profit = Math.max(-prices[i] + helper(i + 1, 0, prices, n,dp), 0 + helper(i + 1, 1, prices, n,dp));
        } else {
            profit = Math.max(prices[i] + helper(i + 1, 1, prices, n,dp), 0 + helper(i + 1, 0, prices, n,dp));
        }

        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy = 0, aheadNotBuy = 0, curBuy = 0, curNotBuy = 0;

        for(int i = n-1; i >= 0; i--) {
            curBuy = Math.max(-prices[i] + aheadNotBuy, aheadBuy);
            curNotBuy = Math.max(prices[i] + aheadBuy,aheadNotBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }

        return aheadBuy;
    }
}