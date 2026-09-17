class Solution {
    public int findCircleNum(int[][] con) {
        int n = con[0].length;
        boolean vis[] = new boolean[n];
        int ans = 1;
        dfs(con , vis , 0);
        for(int i = 1; i < vis.length; i++) {
            if(!vis[i]) {
                ans++;
                dfs(con,vis,i);
            }
        }

        return ans;
    }

    public void dfs(int[][] con, boolean[] vis, int node){
        if(vis[node]) return;

        vis[node]= true;

        for(int i = 0; i < con[node].length; i++) {
            if(con[node][i] == 1) dfs(con,vis,i);
        }
    }
}