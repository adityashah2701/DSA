class Solution {
    // public int lcs(int i, int j, String s, String t, Integer[][] dp) {
    //     if (i == 0 || j == 0)
    //         return 0;
    //     if (dp[i][j] != null)
    //         return dp[i][j];
    //     if (s.charAt(i - 1) == t.charAt(j - 1)) {
    //         return dp[i][j] = 1 + lcs(i - 1, j - 1, s, t, dp);
    //     }

    //     return dp[i][j] = Math.max(lcs(i - 1, j, s, t, dp), lcs(i, j - 1, s, t, dp));
    // }

    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int j = 0; j < m; j++)
            prev[j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[m];
    }
}