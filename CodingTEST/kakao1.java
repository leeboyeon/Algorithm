package CodingTEST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kakao1 {
    static char[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int homeX = -1;
    static int homeY = -1;
    static int destX, destY = -1;
    static int result;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[10][10];
        String[] str = new String[10];
        visit = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = str[i].charAt(j);
                if (map[i][j] == 'H') {
                    homeX = i;
                    homeY = j;
                }
                if (map[i][j] == 'M') {
                    destX = i;
                    destY = j;
                }
            }
        }
        // System.out.println(homeX + " " + homeY);
        bfs();
        // System.out.println(result);
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(homeX, homeY, 1));
        visit[homeX][homeY] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == destY && y == destX) {
                System.out.println(cur.dis);
                result = cur.dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
                    if (map[nx][ny] == '.' && !visit[nx][ny]) {
                        q.offer(new Pair(nx, ny, cur.dis + 1));
                        visit[nx][ny] = true;
                    }
                    if (map[nx][ny] == 'R')
                        continue;
                }
            }

        }

    }

    static class Pair {
        int x;
        int y;
        int dis;

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
