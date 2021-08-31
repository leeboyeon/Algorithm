package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class boj15684_사다리조작 {
    static int[][] map;
    static int result;
    static int N, H, M;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = 2;
        }
        dfs(1, 0);

        System.out.println((result > 3) ? -1 : result);
    }

    public static void dfs(int start, int count) {

        if (move()) {
            result = count;
            return;
        }

        for (int i = start; i < H + 1; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean move() {
        for (int i = 0; i <= N; i++) {
            int x = 1, y = i;
            for (int j = 0; j < H; j++) {
                if (map[x][y] == 1)
                    y++;
                else if (map[x][y] == 2)
                    y--;
                x++;
            }
            if (y != i)
                return false;
        }
        return true;
    }
}
