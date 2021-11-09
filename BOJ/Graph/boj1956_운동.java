package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1956_운동 {
    static int V, E;
    static int[][] graph;
    static int INF = 1000000000;
    // static int[][] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V + 1][V + 1];
        // d = new int[V + 1][V + 1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }
        // for (int i = 0; i < d.length; i++) {
        // Arrays.fill(d[i], INF);
        // }

        // for (int i = 0; i < graph.length; i++) {
        // for (int j = 0; j < graph[i].length; j++) {
        // d[i][j] = graph[i][j];
        // }
        // }
        // 거쳐가는노드
        for (int k = 1; k < V + 1; k++) {
            // 출발노드
            for (int i = 1; i < V + 1; i++) {
                // 도착노드
                for (int j = 1; j < V + 1; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        // for (int i = 1; i < V + 1; i++) {
        // for (int j = 1; j < V + 1; j++) {
        // System.out.print(graph[i][j] + " ");
        // }
        // System.out.println();
        // }
        int result = INF;

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] != INF && graph[j][i] != INF) {
                    result = Math.min(result, graph[i][j] + graph[j][i]);
                }
            }
        }

        // for (int i = 1; i < V + 1; i++) {
        // result = Math.min(result, graph[i][i]);
        // }

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
