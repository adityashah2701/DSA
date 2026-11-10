
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
        int next1 = 0;
        int next2 = 0;
        int next3 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int one = costs[i] + 1 + next1;
            int two = Integer.MAX_VALUE;
            int three = Integer.MAX_VALUE;

            if (i + 2 <= n)
                two = costs[i + 1] + 4 + next2;

            if (i + 3 <= n)
                three = costs[i + 2] + 9 + next3;

            int curr = Math.min(one, Math.min(two, three));

            next3 = next2;
            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}
