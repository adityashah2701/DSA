class Solution {
    public int helper(int i , int j , String s, String t,Integer[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = helper(i-1,j-1,s,t,dp) + helper(i-1,j,s,t,dp);
        } else {
            return dp[i][j] =  helper(i-1,j,s,t,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        Integer[][] dp = new Integer[n][m];
        return helper(n - 1,m - 1,s,t,dp);
    }
}