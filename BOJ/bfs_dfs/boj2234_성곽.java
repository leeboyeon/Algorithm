package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2234_성곽 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int roomCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    max = Math.max(max, bfs(i, j));
                    roomCnt++;
                }
            }
        }
        System.out.println(roomCnt);
        System.out.println(max);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] wall = isWall(map[i][j]);
                for (int k = 0; k < 4; k++) {
                    visit = new boolean[m][n];
                    int[] num = { 8, 4, 2, 1 };
                    if (wall[k]) {
                        map[i][j] -= num[k];
                        max = Math.max(max, bfs(i, j));
                        map[i][j] += num[k];
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;

        int count = 1;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            boolean[] isWall = isWall(map[cur.x][cur.y]);
            for (int i = 0; i < 4; i++) {
                if (isWall[i] == false) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                        continue;
                    if (visit[nx][ny] == true)
                        continue;
                    visit[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    count += 1;
                }

            }
        }
        return count;
    }

    public static boolean[] isWall(int cur) {
        boolean[] wall = new boolean[4];
        int size = wall.length - 1;
        while (cur / 2 != 0) {
            int value = cur % 2;
            if (value == 1) {
                wall[size] = true;
            }
            cur = cur / 2;
            size--;
        }
        if (cur % 2 == 1) {
            wall[size] = true;
        }
        return wall;
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
