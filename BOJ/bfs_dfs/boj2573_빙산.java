package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2573_빙산 {
    private static int n, m;
    private static int[][] map;
    private static Queue<Pair> ice;
    private static Queue<Pair> melt;
    private static boolean[][] visit;
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ice = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    ice.offer(new Pair(i, j));
                }
            }
        }
        int year = 0;
        int check = 0;
        while ((check = checkMap()) <= 1) {
            if (check == 0) {
                year = 0;
                break;
            }
            year++;
            melt();
        }
        System.out.println(year);
    }

    public static int checkMap() {
        int cnt = 0;
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == false) {
                    if (map[i][j] != 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (visit[nx][ny] == false) {
                    if (map[nx][ny] != 0) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }

    public static void melt() {
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    continue;
                visit[i][j] = true;
                int cnt = 0;
                for (int g = 0; g < 4; g++) {
                    int nx = i + dx[g];
                    int ny = j + dy[g];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (visit[nx][ny] == false) {
                            if (map[nx][ny] == 0)
                                cnt++;
                        }
                    }
                }
                if (map[i][j] - cnt <= 0)
                    map[i][j] = 0;
                else
                    map[i][j] -= cnt;
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
