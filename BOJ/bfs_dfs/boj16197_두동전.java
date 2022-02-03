package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16197_두동전 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visit;
    static Queue<Pair> q;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result = 0;

    static class Pair {
        int x;
        int y;
        int count;

        Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
                if (arr[i][j] == 'o') {
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        bfs();

    }

    public static void bfs() {

        while (!q.isEmpty()) {

            Pair cur1 = q.poll();
            Pair cur2 = q.poll();

            if (cur1.count + 1 > 10 || cur2.count + 1 > 10) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                boolean flag1 = false;
                boolean flag2 = false;
                int nx1 = cur1.x + dx[i];
                int ny1 = cur1.y + dy[i];
                int nx2 = cur2.x + dx[i];
                int ny2 = cur2.y + dy[i];

                if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
                    flag1 = true;
                }
                if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
                    flag2 = true;
                }
                if (flag1 == true && flag2 == true) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if (flag1 == true || flag2 == true) {
                    min = Math.min(cur1.count, cur2.count);
                    System.out.println(min + 1);
                    return;
                }
                if (arr[nx1][ny1] == '#' && arr[nx2][ny2] == '#') {
                    continue;
                }
                if (arr[nx1][ny1] == '#') {
                    nx1 = cur1.x;
                    ny1 = cur1.y;
                }
                if (arr[nx2][ny2] == '#') {
                    nx2 = cur2.x;
                    ny2 = cur2.y;
                }

                q.offer(new Pair(nx1, ny1, cur1.count + 1));
                q.offer(new Pair(nx2, ny2, cur2.count + 1));

            }
        }

    }
}
