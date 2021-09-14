package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj18223_민준이와마산그리고건우 {
    static int V, E, P;
    static ArrayList<Graph>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];

        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Graph(b, c));
            list[b].add(new Graph(a, c));
        }

        int[] compare1 = bfs(1);
        int[] compare2 = bfs(P);
        if (compare1[V] >= compare1[P] + compare2[V]) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }

    }

    public static int[] bfs(int start) {
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.add(new Graph(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Graph cur = pq.poll();

            for (int i = 0; i < list[cur.point].size(); i++) {
                Graph next = list[cur.point].get(i);
                if (distance[next.point] > cur.dist + next.dist) {
                    distance[next.point] = cur.dist + next.dist;
                    pq.add(new Graph(next.point, next.dist + cur.dist));
                }
            }
        }
        return distance;
    }

    static class Graph implements Comparable<Graph> {
        int point;
        int dist;

        public Graph(int point, int dist) {
            this.point = point;
            this.dist = dist;
        }

        @Override
        public int compareTo(Graph o) {
            // TODO Auto-generated method stub
            return this.dist - o.dist;
        }

    }
}
