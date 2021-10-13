package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    private static int[] dx = { 1, 0, -1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };
    private static int n;
    private static int m;

    private static int min = 99;
    private static boolean[][] visit = new boolean[n + 1][m + 1];

    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        int result = solution(maps);
        System.out.println(result);
    }

    public static int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;

        return bfs(n, m, maps);
    }

    public static int bfs(int n, int m, int[][] maps) {
        Queue<Pair> q = new LinkedList<>();
        visit = new boolean[n][m];
        visit[0][0] = true;
        q.add(new Pair(0, 0, 1));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                min = cur.count;
                return min;

            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visit[nx][ny]) {
                        if (maps[nx][ny] == 1) {
                            visit[nx][ny] = true;
                            q.add(new Pair(nx, ny, cur.count + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Pair {
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
