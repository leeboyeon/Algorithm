package SWEA.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1249_보급로 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;
    static int N;
    static boolean[][] visit;
    static int result;
    static int[][] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            tmp = new int[N][N];
            visit = new boolean[N][N];
            result = Integer.MAX_VALUE;
            String[] str = new String[N];
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str[i].charAt(j) - '0';
                }
            }

            dfs(0, 0, 0);
            // bfs(0, 0);
            System.out.println("#" + tc + " " + result);
        }
    }

    public static void dfs(int x, int y, int value) {
        // 1.종료조건
        if (result <= value) {
            return;
        }
        if (x == N - 1 && y == N - 1) {
            if (result > value) {
                result = value;
            }
            return;
        }
        // Memoization -> 시간줄이기위해 사용하는 방법
        // tmp배열에 합을 저장해서 출력해내는 방식으로 시간을 단축할 수 있음.!
        if (tmp[x][y] == 0) {
            tmp[x][y] = value;
        } else {
            if (tmp[x][y] > value)
                tmp[x][y] = value;
            else
                return;
        }

        // 2. 방향탐색

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny, (value + map[nx][ny]));
                    visit[nx][ny] = false;
                }
            }

        }

    }

}
