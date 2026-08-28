class Solution {
    public int helper(int i, int j1, int j2, int[][] grid,int r,int c, int[][][] dp){
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return Integer.MIN_VALUE;
        }
        if(i == r - 1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int val = 0;
                if(j1 == j2) val = grid[i][j1];
                else val = grid[i][j1] + grid[i][j2];
                val += helper(i+1,j1+dj1,j2+dj2,grid,r,c,dp);
                max = Math.max(max,val);
            }
        }
        return dp[i][j1][j2] = max;
    }
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        for(int[][] arr1: dp) {
            for(int[] arr: arr1){
                Arrays.fill(arr,-1);
            }
        }
        return helper(0,0,c-1,grid,r,c,dp);
    }
}