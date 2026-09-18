class Pair {
    int f;
    int s;

    Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public static void bfs(int r, int c, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int row = q.peek().f;
            int col = q.peek().s;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' &&
                        vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];

        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c] == 0 && grid[r][c] == '1') {
                    cnt++;
                    bfs(r, c, vis, grid);
                }
            }
        }

        return cnt;
    }
}