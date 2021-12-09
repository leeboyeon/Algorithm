package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj18405_경쟁적전염 {
    static int N, K;
    static int[][] map;
    static PriorityQueue<Pair> q;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int time;
    static int S, X, Y;
    static boolean[][] visit;

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int number;

        public Pair(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        @Override
        public int compareTo(Pair o) {
            return this.number > o.number ? 1 : -1;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        q = new PriorityQueue<>();
        time = 0;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    q.offer(new Pair(i, j, map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        if (q.isEmpty()) {
            System.out.println(0);
        } else {

            while (true) {
                if (S == 0) {
                    System.out.println(map[X][Y]);
                    break;
                }
                bfs();

                time++;

                if (q.size() == 0) {
                    for (int i = 1; i < N + 1; i++) {
                        for (int j = 1; j < N + 1; j++) {
                            if (map[i][j] != 0 && visit[i][j] == false) {
                                for (int k = 0; k < 4; k++) {
                                    int nx = i + dx[k];
                                    int ny = j + dy[k];
                                    if (isWall(nx, ny)) {
                                        if (map[nx][ny] == 0)
                                            q.offer(new Pair(i, j, map[i][j]));
                                    }
                                }

                            }
                        }
                    }
                }

                if (time == S || q.isEmpty()) {
                    System.out.println(map[X][Y]);
                    break;
                }

            }
        }

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            visit[cur.x][cur.y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (isWall(nx, ny)) {
                    if (map[nx][ny] == 0) {
                        if (visit[nx][ny] == false) {
                            map[nx][ny] = map[cur.x][cur.y];
                        }
                    }
                }
            }
        }
    }

    static boolean isWall(int x, int y) {
        if (x > 0 && x < N + 1 && y > 0 && y < N + 1)
            return true;
        return false;
    }
}
