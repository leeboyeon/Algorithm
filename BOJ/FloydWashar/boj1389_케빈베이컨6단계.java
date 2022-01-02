package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1389_케빈베이컨6단계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int INF = 5000001;

        int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
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
        int[] sum = new int[N + 1];
        int tmp = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // min = Math.min(min, graph[i][j]);
                if (i == j) {
                    graph[i][j] = 0;
                }
                tmp += graph[i][j];
            }
            sum[i] = tmp;
            tmp = 0;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i < N; i++) {
            min = Math.min(min, sum[i]);
        }

        for (int i = 1; i < N; i++) {
            if (min == sum[i]) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
