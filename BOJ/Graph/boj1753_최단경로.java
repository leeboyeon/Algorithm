package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753_최단경로 {
    static int V, E, K;
    static ArrayList<Node>[] list;
    static boolean[] visit;
    static int[] tmp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        tmp = new int[V + 1];
        visit = new boolean[V + 1];
        list = new ArrayList[V + 1];

        Arrays.fill(tmp, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < V + 1; i++) {
            if (tmp[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(tmp[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        tmp[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > tmp[cur.v]) {
                continue;
            }
            if (visit[cur.v])
                continue;
            for (int i = 0; i < list[cur.v].size(); i++) {
                Node next = list[cur.v].get(i);
                if (tmp[next.v] > cur.w + next.w) {
                    tmp[next.v] = cur.w + next.w;
                    pq.add(new Node(next.v, tmp[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.w - o.w;
        }

    }
}
