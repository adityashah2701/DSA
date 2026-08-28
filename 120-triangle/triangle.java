class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int m = t.size();
        int[] dp = new int[m];
        for (int j = 0; j < m; j++) {
            dp[j] = t.get(m - 1).get(j);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = t.get(i).get(j) + dp[j];
                int diag = t.get(i).get(j) + dp[j + 1];
                dp[j] = Math.min(down, diag);
            }
        }
        return dp[0];
    }
}