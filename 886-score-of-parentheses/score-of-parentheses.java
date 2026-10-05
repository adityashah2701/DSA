class Solution {
    private int F(String s, int i, int j ,Integer[][] dp){
        int ans = 0 , bal = 0;
        if(dp[i][j - 1] != null) return dp[i][j];
        for(int k = i; k < j; k++) {
            bal += s.charAt(k) == '(' ? 1 : -1;
            if(bal == 0) {
                if(k - i == 1) {
                    ans++;
                } else {
                    ans += 2 * F(s,i+1,k,dp);
                }
                i = k + 1;
            }
        } 

        return dp[i][j] = ans;
    }
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n + 1][n + 1];
        return F(s,0,n,dp);
    }
}