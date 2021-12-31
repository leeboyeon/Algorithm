package BOJ.Graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj5972_택배배송 {
    static int N, M;
    static int[][] graph;
    static int INF = Integer.MAX_VALUE;
    static int dist[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v1][v2] = cost;
            graph[v2][v1] = cost;
        }

        dijksta(1);

        for (int i = 0; i < N + 1; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    static void dijksta(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        pq.add(new int[] { 0, start });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[1];
            if (visit[u])
                continue;
            visit[u] = true;
            for (int v = 1; v < N + 1; v++) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.offer(new int[] { dist[v], v });
                }
            }
        }
    }
}
