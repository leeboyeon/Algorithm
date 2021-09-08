package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1953_탈주범검거 {
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<Pair> q;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];
            count = 1;
            q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(R, C);
            System.out.println("#" + tc + " " + count);
        }

    }

    public static void bfs(int x, int y) {
        q.offer(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            L--;
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int type = map[cur.x][cur.y];
                for (int j = 0; j < 4; j++) {
                    if (j == 0 && (type == 3 || type == 4 || type == 7))
                        continue;
                    if (j == 1 && (type == 2 || type == 6 || type == 7))
                        continue;
                    if (j == 2 && (type == 3 || type == 5 || type == 6))
                        continue;
                    if (j == 3 && (type == 2 || type == 4 || type == 5))
                        continue;

                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        int nextType = map[nx][ny];
                        if (j == 0 && (nextType == 3 || nextType == 4 || nextType == 7))
                            continue;
                        if (j == 1 && (nextType == 2 || nextType == 6 || nextType == 7))
                            continue;
                        if (j == 2 && (nextType == 3 || nextType == 5 || nextType == 6))
                            continue;
                        if (j == 3 && (nextType == 2 || nextType == 4 || nextType == 5))
                            continue;
                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        count++;
                    }
                }
            }
            if (L == 1)
                return;
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
