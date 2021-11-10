package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2468_안전영역 {
    static int N;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<Pair> q;
    static boolean[][] visit;

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

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        q = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int maxCnt = 0;
        for (int k = max; k >= 0; k--) {
            visit = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visit[i][j]) {
                        count += bfs(i, j, k);
                        // q.offer(new Pair(i, j));
                    }
                }
            }
            maxCnt = Math.max(maxCnt, count);
        }
        // if (max == 0) {
        // System.out.println(0);
        // } else if (max == 1) {
        // System.out.println(1);
        // } else {
        // System.out.println(maxCnt);
        // }
        System.out.println(maxCnt);

    }

    public static int bfs(int x, int y, int value) {
        q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visit[nx][ny] == true)
                    continue;
                if (map[nx][ny] > value) {
                    q.offer(new Pair(nx, ny));
                    visit[nx][ny] = true;
                }

            }
        }
        return 1;
    }
}
