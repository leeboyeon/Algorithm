package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11724_연결요소의개수 {
    static int N, M;
    static int[][] graph;
    static boolean isCycler;
    static int result;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = 0;
        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;

        }

        for (int i = 1; i < N + 1; i++) {
            if (visit[i] == false) {
                bfs(i);
                result++;
            }
        }
        System.out.println(result);

    }

    static void bfs(int value) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(value);
        visit[value] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i < N + 1; i++) {
                if (visit[i] == false && graph[cur][i] == 1) {
                    visit[i] = true;
                    q.offer(i);
                }
            }

        }
    }

}
