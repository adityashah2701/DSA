class Solution {
    public int helper(int i , int j , List<List<Integer>> t , int m,int[][] dp) {
        if( i == m-1 ) return t.get(i).get(j);
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int down = t.get(i).get(j) + helper(i + 1,j,t,m,dp);
        int diag = t.get(i).get(j) + helper(i+1,j+1,t,m,dp);

        return dp[i][j] = Math.min(down,diag);

    }
    public int minimumTotal(List<List<Integer>> t) {
        int m = t.size();
        int[][] dp= new int[m][m];
        for(int[] arr: dp) Arrays.fill(arr,Integer.MAX_VALUE);
        return helper(0,0,t,m,dp);
    }
}