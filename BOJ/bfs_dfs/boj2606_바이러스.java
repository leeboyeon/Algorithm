package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2606_바이러스 {
    static int N, V;
    static int[][] graph;
    static int cnt;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        cnt = 0;

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        bfs(1);
        System.out.println(cnt);
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);

        while (!q.isEmpty()) {
            int cur = q.poll();
            visit[cur] = true;
            for (int i = 1; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1 && !visit[i]) {
                    if (cur != i) {
                        q.offer(i);
                        visit[i] = true;
                        cnt++;
                    }

                }
            }
        }

    }
}
