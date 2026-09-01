
class Solution {
    static class State {
        int r, c, e, mask;

        State(int r, int c, int e, int mask) {
            this.r = r;
            this.c = c;
            this.e = e;
            this.mask = mask;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0, k = 0;

        int[][] id = new int[m][n];
        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = k++;
                }
            }
        }

        int fullMask = (1 << k) - 1;

        if (fullMask == 0) {
            return 0;
        }

        int masks = 1 << k;
        int total = m * n * masks * (energy + 1);

        boolean[] visited = new boolean[total];

        ArrayDeque<State> q = new ArrayDeque<>();
        q.offer(new State(sr, sc, energy, 0));

        visited[index(sr, sc, 0, energy, n, masks, energy)] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                State cur = q.poll();

                if (cur.mask == fullMask) {
                    return moves;
                }

                if (cur.e == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X') {
                        continue;
                    }

                    int ne = cur.e - 1;
                    int nmask = cur.mask;

                    if (id[nr][nc] != -1) {
                        nmask |= 1 << id[nr][nc];
                    }

                    if (ch == 'R') {
                        ne = energy;
                    }

                    int idx = index(nr, nc, nmask, ne, n, masks, energy);

                    if (!visited[idx]) {
                        visited[idx] = true;
                        q.offer(new State(nr, nc, ne, nmask));
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int index(int r, int c, int mask, int e,
                      int n, int masks, int energy) {
        return (((r * n + c) * masks + mask) * (energy + 1)) + e;
    }
}