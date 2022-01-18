package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1647_도시분할 {
    static int N, M;
    static ArrayList<Pair>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean[] visit = new boolean[N + 1];
        int result = 0;
        int max = 0;
        pq.offer(new Pair(1, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (visit[cur.to])
                continue;
            result += cur.cost;
            max = Math.max(max, cur.cost);
            visit[cur.to] = true;

            for (Pair next : graph[cur.to]) {
                if (!visit[next.to]) {
                    pq.offer(next);
                }
            }
        }

        result -= max;
        System.out.println(result);

    }

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
}
