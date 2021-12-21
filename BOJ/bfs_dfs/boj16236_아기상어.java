package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16236_아기상어 {
    static int N;
    static int[][] map;
    static Queue<Pair> shark;
    static Queue<Pair> fish;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int max;
    static boolean[][] visit;

    static class Pair {
        int x;
        int y;
        int size;

        public Pair(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        shark = new LinkedList<>();
        visit = new boolean[N][N];

        max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark.offer(new Pair(i, j, 2));
                } else if (map[i][j] != 9 && map[i][j] != 0) {
                    max = Math.max(max, map[i][j]);

                }
            }
        }
        bfs();
    }

    static void bfs() {
        int time = 0;
        while (!shark.isEmpty()) {
            Pair cur = shark.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (visit[nx][ny] == true)
                    continue;
                if (map[nx][ny] == 0 && visit[nx][ny] == false) {
                    time++;
                    shark.offer(new Pair(nx, ny, cur.size));
                }
                if (map[nx][ny] != 0 && visit[nx][ny] == false) {
                    if (map[nx][ny] < cur.size) {
                        shark.offer(new Pair(nx, ny, cur.size));
                        map[nx][ny] = 0;
                        visit[nx][ny] = true;

                    }
                    if (map[nx][ny] == cur.size) {
                        shark.offer(new Pair(nx, ny, cur.size + 1));
                        map[nx][ny] = 0;
                        visit[nx][ny] = true;

                    }
                }
            }
            if (cur.size == max) {
                System.out.println(time);
                break;
            }
        }

        System.out.println(time);
    }
}
