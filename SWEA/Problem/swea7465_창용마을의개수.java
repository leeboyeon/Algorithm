package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7465_창용마을의개수 {
    static int[][] graph;
    static int M, N;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visit = new boolean[N + 1];
            count = 1;
            graph = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph[v1][v2] = 1;
                graph[v2][v1] = 1;
            }
            for (int i = 1; i < N + 1; i++) {
                if (!visit[i]) {
                    dfs(i, N + 1);
                    for (int j = 1; j < N + 1; j++) {
                        if (!visit[j]) {
                            count++;
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }

    }

    public static void dfs(int start, int end) {
        if (!visit[start]) {
            visit[start] = true;

            for (int i = 1; i < end; i++) {
                if (graph[start][i] == 1 && !visit[i]) {
                    dfs(i, end);
                }
            }
        }
    }
}
