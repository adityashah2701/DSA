class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {

                int max = 0;

                for (int idx = i; idx <= j; idx++) {

                    int cost = arr[i - 1] * arr[idx] * arr[j + 1]
                             + dp[i][idx - 1]
                             + dp[idx + 1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}