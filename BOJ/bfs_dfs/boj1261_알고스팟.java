package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1261_알고스팟 {
    static int N, M;
    static int[][] map;
    static PriorityQueue<Pair> q;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result = 0;

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int breaked;

        public Pair(int x, int y, int breaked) {
            this.x = x;
            this.y = y;
            this.breaked = breaked;
        }

        @Override
        public int compareTo(Pair o) {
            return this.breaked - o.breaked;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        q = new PriorityQueue<>();

        String[] input = new String[M];
        for (int i = 0; i < M; i++) {
            input[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[i].charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(result);
    }

    static void bfs() {
        boolean[][] visit = new boolean[M][N];
        q.offer(new Pair(0, 0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.x == M - 1 && cur.y == N - 1) {
                result = cur.breaked;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N)
                    continue;
                if (visit[nx][ny])
                    continue;
                if (map[nx][ny] == 1) {
                    q.offer(new Pair(nx, ny, cur.breaked + 1));
                    // map[nx][ny] = 0;
                    visit[nx][ny] = true;
                }
                if (map[nx][ny] == 0) {
                    q.offer(new Pair(nx, ny, cur.breaked));
                    visit[nx][ny] = true;
                }
            }
        }

    }
}
