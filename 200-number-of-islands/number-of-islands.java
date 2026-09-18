class Solution {

    public int numIslands(char[][] grid) {

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }

            }
        }

        return result;
    }

    public void dfs(int x, int y, char[][] grid) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }
}