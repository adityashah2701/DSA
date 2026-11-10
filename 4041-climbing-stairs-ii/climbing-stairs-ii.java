
class Solution {
    private static int helper(int i, int[] costs, int n, Integer[] dp) {
        if (i == n)
            return 0;

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        if (dp[i] != null)
            return dp[i];
        if (i + 1 <= n)
            one = costs[i] + 1 + helper(i + 1, costs, n, dp);

        if (i + 2 <= n)
            two = costs[i + 1] + 4 + helper(i + 2, costs, n, dp);

        if (i + 3 <= n)
            three = costs[i + 2] + 9 + helper(i + 3, costs, n, dp);

        return dp[i] = Math.min(one, Math.min(two, three));
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int one = Integer.MAX_VALUE;
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if (i + 1 <= n)
                one = costs[i] + 1 + dp[i + 1];

            if (i + 2 <= n)
                two = costs[i + 1] + 4 + dp[i + 2];

            if (i + 3 <= n)
                three = costs[i + 2] + 9 + dp[i + 3];

            dp[i] = Math.min(one, Math.min(two, three));
        }

        return dp[0];
    }
}
