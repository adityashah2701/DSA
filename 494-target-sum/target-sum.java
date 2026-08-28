class Solution {
    public int helper(int i, int[] nums, int t, int sum,Integer[][] dp) {
        if (t == sum && i > nums.length-1)
            return 1;
        if (i >= nums.length)
            return 0;
        if(dp[i][sum+2000] != null) 
            return dp[i][sum+2000];

        int a = helper(i + 1, nums, t, sum + nums[i],dp);
        int s = helper(i + 1, nums, t, sum - nums[i],dp);

        return dp[i][sum+2000] = a + s;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] dp = new Integer[nums.length][4001];
        return helper(0, nums, target, 0, dp);
    }
}