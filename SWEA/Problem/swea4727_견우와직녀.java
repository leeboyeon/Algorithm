package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea4727_견우와직녀 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static Queue<Pair> q;
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            q = new LinkedList<>();
            visit = new boolean[N][N];
        }

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (map[nx][ny] == 1)
                    continue;
                if (visit[nx][ny] == true)
                    continue;

                map[nx][ny] = map[cur.x][cur.y] + 1;

            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}