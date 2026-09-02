class Solution {
    public int helper(int i , int j , String w1 , String w2, Integer[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != null) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j)) {
            return helper(i-1,j-1,w1,w2,dp);
        } 

        int insert = 1 + helper(i,j-1,w1,w2,dp);
        int delete = 1 + helper(i-1,j,w1,w2,dp);
        int replace = 1 +helper(i-1,j-1,w1,w2,dp);

        return dp[i][j] = Math.min(insert , Math.min(delete,replace));
        
    }
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        Integer[][] dp = new Integer[i][j];
        return helper(i-1,j-1,word1,word2,dp);
    }
}