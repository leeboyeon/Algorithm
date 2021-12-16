package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562_나이트의이동 {
    static int[][] map;
    static int[] dx = { -2, -1, 2, 1, 2, 1, -2, -1 };
    static int[] dy = { 1, 2, 1, 2, -1, -2, -1, -2 };
    static boolean[][] visit;
    static Queue<Pair> q;
    static int size;
    static int answer = 0;

    static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int T = 1; T <= tc; T++) {
            size = Integer.parseInt(br.readLine());

            map = new int[size][size];
            visit = new boolean[size][size];
            q = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = 0;
                }
            }
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");

            int curX = Integer.parseInt(input1[0]);
            int curY = Integer.parseInt(input1[1]);

            int goalX = Integer.parseInt(input2[0]);
            int goalY = Integer.parseInt(input2[1]);

            bfs(curX, curY, goalX, goalY);

            System.out.println(answer);
        }

    }

    static void bfs(int x, int y, int endX, int endY) {
        int result = 0;
        visit[x][y] = true;
        q.offer(new Pair(x, y, 0));

        if (x == endX && y == endY) {
            answer = result;
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= size || ny < 0 || ny >= size)
                    continue;
                if (visit[nx][ny])
                    continue;
                if (nx == endX && ny == endY) {
                    answer = cur.cnt + 1;
                }

                q.offer(new Pair(nx, ny, cur.cnt + 1));
                visit[nx][ny] = true;

            }

        }
    }
}
