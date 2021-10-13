package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2638_Chesse {
    static int n, m;
    static int[][] map;
    static Queue<Pair> q;
    static Queue<Pair> melt;
    static boolean[][] visit;
    static int time;
    static int cheeseCnt;
    static int result;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        melt = new LinkedList<>();
        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheeseCnt++;
            }
        }

        time = 0;
        while (cheeseCnt != 0) {
            q.offer(new Pair(0, 0));
            meltingcheese();
            visit = new boolean[n][m];
            check();
            time++;
            count();
        }
        System.out.println(time);
    }

    public static void meltingcheese() {
        visit = new boolean[n][m];

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visit[nx][ny] == false) {
                        if (map[nx][ny] != 1) {
                            visit[nx][ny] = true;
                            map[nx][ny] = 2;
                            q.offer(new Pair(nx, ny));
                        }
                    }
                }

            }
        }
    }

    public static void check() {
        int check_two = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (map[nx][ny] == 2) {
                                check_two++;
                            }

                        }
                    }
                    if (check_two >= 2) {
                        melt.offer(new Pair(i, j));
                    }
                    check_two = 0;
                }
            }
        }

        while (!melt.isEmpty()) {
            Pair cur = melt.poll();
            map[cur.x][cur.y] = 2;
        }
    }

    public static void count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1)
                    cnt++;
            }
        }
        cheeseCnt = cnt;
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
