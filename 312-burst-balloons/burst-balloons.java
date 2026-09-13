class Solution {

    private static int f(int i, int j, int[] arr,Integer[][] dp) {
        if (i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int max = 0;

        for (int idx = i; idx <= j; idx++) {

            int cost = arr[i - 1] * arr[idx] * arr[j + 1]
                     + f(i, idx - 1, arr,dp)
                     + f(idx + 1, j, arr,dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        Integer[][] dp = new Integer[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        return f(1, n, arr,dp);
    }
}