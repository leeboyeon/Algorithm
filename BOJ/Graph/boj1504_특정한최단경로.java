package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1504_특정한최단경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        long[][] graph = new long[N + 1][N + 1];
        long INF = 200000000;

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());

            graph[v1][v2] = value;
            graph[v2][v1] = value;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int via1 = Integer.parseInt(st.nextToken());
        int via2 = Integer.parseInt(st.nextToken());

        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (graph[from][to] > graph[from][via] + graph[via][to]) {
                        graph[from][to] = graph[from][via] + graph[via][to];
                    }
                }
            }
        }

        long result1 = 0;
        long result2 = 0;

        result1 = graph[1][via1] + graph[via1][via2] + graph[via2][N];
        result2 = graph[1][via2] + graph[via2][via1] + graph[via1][N];

        if (via1 == 1 || via2 == 1) {
            if (via1 == N || via2 == N) {
                System.out.println(graph[1][N]);
            }
        } else if (result1 >= INF || result2 >= INF) {
            System.out.println("-1");
        } else {
            long result = Math.min(result1, result2);
            System.out.println(result);

        }

    }
}
