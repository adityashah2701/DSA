class Solution {
    public int helper(int i, int[] a, int t, Integer[][] dp) {
        if (i == 0) {
            if (t % a[i] == 0)
                return t / a[i];
            else
                return (int) 1e9;
        }
        if (dp[i][t] != null)
            return dp[i][t];
        int notTake = 0 + helper(i - 1, a, t, dp);
        int take = Integer.MAX_VALUE;
        if (a[i] <= t)
            take = 1 + helper(i, a, t - a[i], dp);

        return dp[i][t] = Math.min(notTake, take);

    }

    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        int ans = helper(coins.length - 1, coins, amount, dp);
        return ans >= 1e9 ? -1 : ans;
    }
}