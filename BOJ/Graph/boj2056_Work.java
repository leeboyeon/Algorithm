package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2056_Work {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static int[] time;
    static int max;

    /**
     * 위상정렬
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        indegree = new int[N + 1];
        time = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph.get(value).add(i);

                indegree[i]++;
            }
        }

        indegreeSort();

        System.out.println(max);
    }

    static void indegreeSort() {
        Queue<Integer> q = new LinkedList<>();
        int[] sum = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            sum[i] = time[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int value = q.poll();

            for (int i : graph.get(value)) {
                sum[i] = Math.max(sum[i], sum[value] + time[i]);

                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, sum[i]);
        }
    }
}
