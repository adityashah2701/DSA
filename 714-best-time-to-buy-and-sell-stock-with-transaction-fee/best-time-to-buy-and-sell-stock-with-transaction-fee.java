class Solution {
    //TOP DOWN
    // public int helper(int i, int buy, int[] prices, int fee, int n, Integer dp[][]) {

    //     if (i == n)
    //         return 0;

    //     if (dp[i][buy] != null)
    //         return dp[i][buy];

    //     int profit;

    //     if (buy == 1) {

    //         profit = Math.max(
    //             -prices[i] + helper(i + 1, 0, prices, fee, n, dp),
    //             helper(i + 1, 1, prices, fee, n, dp)
    //         );

    //     } else {

    //         profit = Math.max(
    //             prices[i] - fee + helper(i + 1, 1, prices, fee, n, dp),
    //             helper(i + 1, 0, prices, fee, n, dp)
    //         );
    //     }

    //     return dp[i][buy] = profit;
    // }
    //BOTTOM UP
    public int maxProfit(int[] prices, int fee) {
        // int n = prices.length;
        // Integer dp[][] = new Integer[n][2];

        int buy = 0;
        int sell = 0;

        for (int i = prices.length - 1; i >= 0; i--) {

            int curBuy = Math.max(
                -prices[i] + sell,
                buy
            );

            int curSell = Math.max(
                prices[i] - fee + buy,
                sell
            );

            buy = curBuy;
            sell = curSell;
        }

        return buy;
    }
}