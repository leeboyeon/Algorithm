package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1197_MST {

    static int V, E;
    static Edge[] graph;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new Edge[E];
        parent = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i] = new Edge(a, b, c);
        }

    }

    public static int krusckal() {
        // 정렬
        Arrays.sort(graph);
        // graph 만들기
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        for(Edge edge : graph){
            if()
        }
    }

    public static boolean union(int a, int b) {

    }
}
