class Solution {
    public int helper(int i, int j, int[][] g, int[][] dp) {

        if (i == 0 && j == 0)
            return g[i][j];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE / 2;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = g[i][j] + helper(i - 1, j, g, dp);
        int left = g[i][j] + helper(i, j - 1, g, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return helper(m - 1, n - 1, grid, dp);
    }
}