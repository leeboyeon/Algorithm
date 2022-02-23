package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11404_플로이드 {
    static int[][] graph;
    static int N, M;
    static int INF = 100000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                graph[i][j] = INF;
                if (i == j) {
                    graph[i][j] = 0;
                }

            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int cost = Math.min(graph[a][b], c);
            graph[a][b] = cost;
        }

        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (graph[from][to] > graph[from][via] + graph[via][to]) {
                        graph[from][to] = graph[from][via] + graph[via][to];
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (graph[i][j] == INF) {
                    graph[i][j] = 0;
                }

                System.out.print(graph[i][j] + " ");

            }
            System.out.println();
        }
    }
}
