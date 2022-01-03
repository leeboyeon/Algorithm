package BOJ.Graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916_최소비용구하기 {
    static int N, M;
    static int INF = 1000000001;
    static ArrayList<Pair>[] map;
    static int[] dist;

    static class Pair implements Comparable<Pair> {
        int to;
        int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[u].add(new Pair(v, cost));
            // map[v].add(new Pair(u, cost));

        }
        st = new StringTokenizer(br.readLine(), " ");
        int sPoint = Integer.parseInt(st.nextToken());
        int ePoint = Integer.parseInt(st.nextToken());

        dijkstra(sPoint);
        // for (int i = 1; i < dist.length; i++) {
        // System.out.println(dist[i]);
        // }
        System.out.println(dist[ePoint]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        boolean[] visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = INF;
        }

        pq.offer(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int go = cur.to;

            if (visit[go]) {
                continue;
            } else {
                visit[cur.to] = true;
            }

            for (Pair next : map[go]) {
                if (!visit[next.to]) {
                    if (dist[next.to] > dist[go] + next.cost) {
                        dist[next.to] = dist[go] + next.cost;
                        pq.offer(new Pair(next.to, dist[next.to]));
                    }
                }
            }
        }

    }
}
