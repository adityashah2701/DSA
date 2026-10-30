import java.util.*;

class Solution {
    static class State {
        int node;
        int cnt;
        long dist;

        State(int node, int cnt, long dist) {
            this.node = node;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int u = cur.node;
            int cnt = cur.cnt;
            long d = cur.dist;

            if (d != dist[u][cnt]) continue;

            if (u == n - 1) {
                return (int) d;
            }

            for (int[] nxt : graph[u]) {
                int v = nxt[0];
                int w = nxt[1];

                int newCnt;

                if (labels.charAt(v) == labels.charAt(u)) {
                    newCnt = cnt + 1;
                } else {
                    newCnt = 1;
                }

                if (newCnt > k) continue;

                long nd = d + w;

                if (nd < dist[v][newCnt]) {
                    dist[v][newCnt] = nd;
                    pq.offer(new State(v, newCnt, nd));
                }
            }
        }

        return -1;
    }
}