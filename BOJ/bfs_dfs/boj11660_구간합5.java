package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11660_구간합5 {
    static int N;
    static int M;
    static int[][] map;
    static Queue<Pair> q;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            q.offer(new Pair(x1, y1));

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            q.offer(new Pair(x2, y2));

            solution();
        }

    }

    static void solution() {
        int result = 0;
        while (!q.isEmpty()) {
            Pair start = q.poll();
            Pair end = q.poll();

            for (int i = start.x; i <= end.x; i++) {
                for (int j = start.y; j <= end.y; j++) {
                    result += map[i][j];
                }
            }
        }

        System.out.println(result);
    }
}
