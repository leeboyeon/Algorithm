package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1719_택배 {
    static int N, M;
    static int[][] graph;
    static int INF = 20000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        int[][] count = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v1][v2] = cost;
            graph[v2][v1] = cost;

            count[v1][v2] = v1;
            count[v2][v1] = v2;
        }

        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (graph[from][to] > graph[from][via] + graph[via][to]) {
                        count[from][to] = count[via][to];
                        graph[from][to] = graph[from][via] + graph[via][to];
                    }
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    System.out.print("- ");
                } else {
                    System.out.print(count[j][i] + " ");
                }
            }
            System.out.println();
        }
        // for (int i = 1; i < N + 1; i++) {
        // for (int j = 1; j < N + 1; j++) {
        // if (graph[i][j] == INF) {
        // sb.append("-").append(" ");
        // } else if (i == j) {
        // sb.append("-").append(" ");
        // } else {
        // sb.append(graph[i][j]).append(" ");
        // }

        // }
        // sb.append("\n");
        // }

        // System.out.println(sb.toString());
    }
}
