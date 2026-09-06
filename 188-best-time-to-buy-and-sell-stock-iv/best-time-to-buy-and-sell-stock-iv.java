class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        // Integer[][][] dp = new Integer[n][2][3];
        // return helper(0,1,2,prices,n,dp);
        int[][] after = new int[2][k + 1];
        int[][] cur = new int[2][k+1];

        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy < 2; buy++) {
                for(int cap = 1; cap <= k; cap++){
                     if (buy == 1) {
                         cur[buy][cap] = Math.max(-prices[i] + after[0][cap],after[1][cap]);
                    } else {
                         cur[buy][cap] = Math.max(prices[i] + after[1][cap - 1],after[0][cap]);
                    }
                }
            }
            after = cur;
        } 

        return after[1][k];
    }
}