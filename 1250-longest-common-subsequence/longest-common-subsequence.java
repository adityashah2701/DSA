class Solution {
    public int lcs(int i , int j , String s , String t,Integer[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + lcs(i - 1, j - 1 , s , t,dp);
        } 

        return dp[i][j] = Math.max(lcs(i - 1,j,s,t,dp),lcs(i,j-1,s,t,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        Integer[][] dp = new Integer[n][m];

        
        return lcs(n-1,m-1,text1,text2,dp);
    }
}