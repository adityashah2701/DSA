class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] a = new int[m + 2];
        a[0] = 0;
        a[m + 1] = n;
        for (int i = 0; i < m; i++) {
            a[i + 1] = cuts[i];
        }
        int[][] dp = new int[m + 2][m + 2];
        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = a[j + 1] - a[i - 1]
                             + dp[i][k - 1]
                             + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m];
    }
}