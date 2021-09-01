package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2667_단지번호붙이기 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str[i].charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false && map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count - 1);
        int[] result = new int[count];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    result[map[i][j]]++;
                }
            }
        }
        Arrays.sort(result);
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public static void dfs(int x, int y) {
        map[x][y] = count;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (visit[nx][ny] == false && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }

    }
}
