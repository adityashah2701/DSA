class Solution {

    public long dfs(int i , int j , int[][] g, boolean[][] v) {
        int n = g.length;
        int m = g[0].length;

        if(i < 0 || j < 0 || i >= n || j >= m || g[i][j] == 0 || v[i][j]) {
            return 0;
        }

        v[i][j] = true;

        long sum = g[i][j];

        sum += dfs(i + 1, j , g,v);
        sum += dfs(i - 1, j , g,v);
        sum += dfs(i, j + 1 , g,v);
        sum += dfs(i, j - 1 , g,v);

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]  != 0 && !visited[i][j]) {
                    long sum = dfs(i, j , grid, visited);

                    if (sum % k == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}