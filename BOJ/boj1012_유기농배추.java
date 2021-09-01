package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012_유기농배추 {
    static int[][] map;
    static int N, M, K;
    static boolean[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 가로 x
            N = Integer.parseInt(st.nextToken()); // 세로 y
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            count = 0;
            map = new int[N][M];
            visit = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && visit[i][j] == false) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visit[nx][ny] == false && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
