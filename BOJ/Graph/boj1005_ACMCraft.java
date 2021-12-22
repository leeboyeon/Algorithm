package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

public class boj1005_ACMCraft {
    static int N, K, W;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] second;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            second = new int[N + 1];
            indegree = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < N + 1; i++) {
                second[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                indegree[y]++;
            }
            W = Integer.parseInt(br.readLine());

            solution();

        }

    }

    static void solution() {
        Queue<Integer> q = new LinkedList<>();
        int[] sum = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            sum[i] = second[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int value = q.poll();

            for (int i : graph.get(value)) {
                sum[i] = Math.max(sum[i], sum[value] + second[i]);

                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(sum[W]);
    }

}
