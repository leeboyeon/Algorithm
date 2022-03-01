package BOJ.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023_ABCDE {
    // static int[][] graph;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int N, M;
    static boolean result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph = new int[N][N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
            // graph[v1][v2] = 1;
            // graph[v2][v1] = 1;
        }

        result = false;
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            dfs(i, 1);
            if (result) {
                bw.write("1");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write("0");
        bw.flush();
        bw.close();

    }

    static void dfs(int x, int count) {
        if (count == 5) {
            result = true;
            return;
        }
        visit[x] = true;

        for (int next : graph[x]) {
            if (visit[next] == false) {
                dfs(next, count + 1);
            }
        }

        // for (int i = 0; i < N; i++) {
        // if (graph[x][i] == 1) {
        // if (visit[i] == false) {
        // dfs(i, count + 1);
        // }
        // }
        // }
        visit[x] = false;
    }
}
