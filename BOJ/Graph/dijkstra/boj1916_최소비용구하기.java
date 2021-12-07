package BOJ.Graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916_최소비용구하기 {
    static int N, M;
    static int INF = 1000000000;
    static int[][] map;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j)
                    map[i][j] = 0;
                else
                    map[i][j] = INF;
            }
        }
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            map[u][v] = map[v][u] = cost;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int sPoint = Integer.parseInt(st.nextToken());
        int ePoint = Integer.parseInt(st.nextToken());

        dijkstra(sPoint);
        System.out.println(dist[ePoint] + 1);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = INF;
        }

        pq.offer(new int[] { 0, start });
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[1];
            if (visit[u])
                continue;

            visit[u] = true;
            for (int v = 1; v < N + 1; v++) {
                if (dist[v] > dist[u] + map[u][v]) {
                    dist[v] = dist[u] + map[u][v];
                    pq.offer(new int[] { dist[v], v });
                }
            }
        }
    }
}
