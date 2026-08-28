class Solution {
    static boolean helper(int i, int[] arr, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (i == 0)
            return arr[0] == sum;
        if (dp[i][sum] != null)
            return dp[i][sum];
        boolean notTake = helper(i - 1, arr, sum, dp);
        boolean take = false;
        if (sum >= arr[i])
            take = helper(i - 1, arr, sum - arr[i], dp);
        return dp[i][sum] = take || notTake;
    }

    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum + 1];
        return helper(n - 1, arr, sum, dp);

    }

    public boolean canPartition(int[] nums) {
        int tSum = 0;
        for(int x : nums) tSum += x;
        if(tSum % 2 == 1) return false;
        return isSubsetSum(nums,tSum/2);
    }
}