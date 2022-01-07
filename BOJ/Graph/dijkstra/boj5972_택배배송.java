package BOJ.Graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 모든 정점을 연결할꺼면 prim
 * 시작점과 끝점을 모두 알면 dijkstra
 * INF = Integer.MAX_VALUE/2
 */
public class boj5972_택배배송 {
    static int N, M;
    static int[][] graph;
    static int INF = 50000001;
    static int[] dist;
    static ArrayList<Pair>[] list;

    static class Pair implements Comparable<Pair> {
        int to, weight;

        Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[v1].add(new Pair(v2, cost));
            list[v2].add(new Pair(v1, cost));
        }

        dijksta(1);

        System.out.println(dist[N]);
    }

    static void dijksta(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int dest = cur.to;

            if (visit[dest]) {
                continue;
            } else {
                visit[cur.to] = true;
            }

            for (Pair next : list[dest]) {
                if (dist[next.to] > dist[dest] + next.weight) {
                    dist[next.to] = dist[dest] + next.weight;
                    pq.offer(new Pair(next.to, dist[next.to]));
                }

            }
        }
    }
}
