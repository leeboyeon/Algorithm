package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589_보물섬 {
    static int n, m;
    static char[][] map;
    static Queue<Pair> l;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int answer;
    static boolean[][] visit;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        answer = 0;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visit = new boolean[n][m];
                    bfs(i, j);

                }
            }
        }

        System.out.println(result);

    }

    public static void bfs(int x, int y) {
        int time = 0;
        l = new LinkedList<>();
        l.offer(new Pair(x, y, 0));
        visit[x][y] = true;
        while (!l.isEmpty()) {
            Pair cur = l.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (map[nx][ny] == 'W')
                    continue;
                if (visit[nx][ny] == true)
                    continue;
                visit[nx][ny] = true;
                l.offer(new Pair(nx, ny, cur.time + 1));

                answer = Math.max(answer, cur.time + 1);

            }
        }
        result = Math.max(answer, result);

    }

    static class Pair {
        int x;
        int y;
        int time;

        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
