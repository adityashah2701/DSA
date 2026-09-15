class Solution {
    public static int helper(int i, int k, int[] arr, int n, Integer[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != null)
            return dp[i];
        int len = 0, ans = 0, maxi = -1;

        for (int j = i; j < Math.min(n, i + k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (maxi * len) + helper(j + 1, k, arr, n, dp);
            ans = Math.max(ans, sum);
        }

        return dp[i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int len = 0, ans = 0, maxi = -1;

            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (maxi * len) + dp[j + 1];
                ans = Math.max(ans, sum);
            }

             dp[i] = ans;
        }
        return dp[0];
    }
}