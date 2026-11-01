class Solution {
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[node] = path[node] = true;

        for (int next : adj.get(node))
            if (!vis[next] && dfs(next, adj, vis, path)) return true;
            else if (path[next]) return true;
            
        path[node] = false;
        return false;
    }
    public boolean canFinish(int nC, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < nC; i++) adj.add(new ArrayList<>());

        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] vis = new boolean[nC];
        boolean[] path = new boolean[nC];

        for (int i = 0; i < nC; i++)
            if (!vis[i] && dfs(i, adj, vis, path)) return false;

        return true;
     }
}