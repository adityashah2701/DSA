class Solution {
    public static int f(int i, int[] nums, int n, Integer[] dp) {
        if (i >= n - 1)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int min = Integer.MAX_VALUE;

        for (int idx = 1; idx <= nums[i]; idx++) {
            if (i + idx < n) {
                int jumps = f(i + idx, nums, n, dp);

                if (jumps != Integer.MAX_VALUE) {
                    min = Math.min(min, jumps + 1);
                }
            }
        }

        return dp[i] = min;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];

        return f(0, nums, n, dp);
    }
}