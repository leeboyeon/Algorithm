package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206_벽부수고이동하기 {
    static int[][] map;
    static boolean[][][] visit;
    static int N, M;
    static int result;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str[i].charAt(j) - '0';
            }
        }
        bfs();
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == N - 1 && y == M - 1) {
                result = cur.dis;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (visit[nx][ny][cur.wallcnt] == false) {

                            q.add(new Pair(nx, ny, cur.dis + 1, cur.wallcnt));
                            visit[nx][ny][cur.wallcnt] = true;
                        }
                    } else {
                        if (cur.wallcnt == 0 && visit[nx][ny][cur.wallcnt + 1] == false) {

                            q.add(new Pair(nx, ny, cur.dis + 1, cur.wallcnt + 1));
                            visit[nx][ny][cur.wallcnt + 1] = true;
                        }
                    }
                }
            }
        }
        if (result == 0) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }

    static class Pair {
        int x;
        int y;
        int dis;
        int wallcnt;

        public Pair(int x, int y, int dis, int wallcnt) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wallcnt = wallcnt;
        }
    }

}
