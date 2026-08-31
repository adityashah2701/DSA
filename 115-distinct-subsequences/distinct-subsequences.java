class Solution {
    // public int helper(int i, int j, String s, String t, Integer[][] dp) {
    //     if (j < 0)
    //         return 1;
    //     if (i < 0)
    //         return 0;
    //     if (dp[i][j] != null)
    //         return dp[i][j];
    //     if (s.charAt(i) == t.charAt(j)) {
    //         return dp[i][j] = helper(i - 1, j - 1, s, t, dp) + helper(i - 1, j, s, t, dp);
    //     } else {
    //         return dp[i][j] = helper(i - 1, j, s, t, dp);
    //     }
    // }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m + 1];
        
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = 1; 
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                     cur[j] = dp[j - 1] + dp[j];
                } else {
                     cur[j] = dp[j];
                }
            }
            dp = cur;
        }
        return dp[m];
    }
}