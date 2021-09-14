package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj18223_민준이와마산그리고건우 {
    static int V, E, P;
    static PriorityQueue<Graph> graph = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Graph(a, b, c));
        }

    }

    public static void dfs() {

    }

    static class Graph {
        int v1;
        int v2;
        int w;

        public Graph(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;

        }

    }
}
