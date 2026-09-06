class Solution {
    //TOP DOWN
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

    //BOTTOM UP
  public int maxProfit(int[] prices) {
    int n = prices.length;

    int[] f1 = new int[2]; // dp[i + 1]
    int[] f2 = new int[2]; // dp[i + 2]
    int[] c = new int[2];  // dp[i]

    for (int i = n - 1; i >= 0; i--) {

        c[1] = Math.max(
                -prices[i] + f1[0],
                f1[1]
        );

        c[0] = Math.max(
                prices[i] + f2[1],
                f1[0]
        );

        int[] temp = f2;
        f2 = f1;
        f1 = c;
        c = temp;
    }

    return f1[1];
}
}