import java.util.Arrays;

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int INF = Integer.MAX_VALUE;
        int[] distances = new int[N + 1];
        Arrays.fill(distances, INF);
        distances[K] = 0;

        for (int i = 1; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (distances[u] != INF && distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w;
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= N; i++) {
            maxDelay = Math.max(maxDelay, distances[i]);
        }

        return maxDelay == INF ? -1 : maxDelay;
    }
}
