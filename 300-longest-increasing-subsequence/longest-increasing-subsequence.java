class Solution {
    public int helper(int i, int prev, int[] nums, Integer[][] dp) {
        if (i >= nums.length)
            return 0;
        if(dp[i][prev + 1] != null) return dp[i][prev + 1];
        int notTake = helper(i + 1, prev, nums,dp);
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + helper(i + 1, i, nums,dp);
        }
        return dp[i][prev + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1];
        return helper(0,-1, nums,dp);
    }
}