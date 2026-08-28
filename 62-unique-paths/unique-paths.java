class Solution {
    public int helper(int i , int j , int[][] dp) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = helper(i - 1,j,dp);
        int left = helper(i,j-1,dp);

        return dp[i][j] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        for(int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) temp[j] = 1;
                else {
                    int down = 0 , right = 0;
                    if(i > 0) down = dp[j];
                    if(j > 0) right = temp[j - 1];
                    temp[j] = down + right;
                }
            }
            dp = temp;
        }

        return dp[n-1];
    }
}