class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int[] dp = new int[n + 1];
        int[] cnt = new int[n + 1];
        int max = 1;
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for(int i = 0; i < n; i++) {
            for(int p = 0; p < i; p++) {
                if(nums[p] < nums[i] && 1 + dp[p] > dp[i]) {
                    dp[i] = 1 + dp[p];
                    cnt[i] = cnt[p];
                } else if (nums[p] < nums[i] && dp[p] + 1 == dp[i]) {
                    cnt[i] += cnt[p];
                } 
            }
            max = Math.max(max,dp[i]);
        }

        int nos = 0;
        for(int i = 0 ; i < n; i++) {
            if(dp[i] == max) nos += cnt[i];
        }

        return nos;
    }
}