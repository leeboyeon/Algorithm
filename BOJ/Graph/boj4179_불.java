package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4179_불 {
    static int N, M;
    static char[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] visit;
    static Queue<Pair> fire;
    static Queue<Pair> start;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        fire = new LinkedList<>();
        start = new LinkedList<>();
        time = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'F') {
                    fire.add(new Pair(i, j, 0));
                }
                if (map[i][j] == 'J') {
                    start.add(new Pair(i, j, 0));
                }
            }
        }
        if (spreadFire()) {
            System.out.println(time);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

    public static Boolean spreadFire() {

        while (!start.isEmpty()) {
            int firesize = fire.size();
            for (int j = 0; j < firesize; j++) {
                Pair fireCur = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = fireCur.x + dx[i];
                    int ny = fireCur.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'F';
                            fire.offer(new Pair(nx, ny, fireCur.count + 1));
                        }

                    }
                }
            }
            int startsize = start.size();
            for (int j = 0; j < startsize; j++) {
                Pair startCur = start.poll();
                for (int i = 0; i < 4; i++) {

                    int nx = startCur.x + dx[i];
                    int ny = startCur.y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        time = startCur.count + 1;
                        return true;
                    }
                    if (map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J')
                        continue;
                    map[nx][ny] = 'J';
                    start.offer(new Pair(nx, ny, startCur.count + 1));
                }
            }
        }
        return false;
    }

    static public class Pair {
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
