class Solution {
    public int helper(int i, int j, int[][] og, int[][] dp) {
       if (i < 0 || j < 0)
            return 0;

        if (og[i][j] == 1)
            return 0;

        if (i == 0 && j == 0)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = helper(i - 1, j, og, dp);
        int left = helper(i, j - 1, og, dp);

        return dp[i][j] = up + left;
    }

    public int uniquePathsWithObstacles(int[][] og) {
        int m = og.length;
        int n = og[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        return helper(m - 1, n - 1, og, dp);
    }
}