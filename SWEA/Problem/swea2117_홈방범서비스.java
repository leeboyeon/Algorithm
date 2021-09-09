package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea2117_홈방범서비스 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int sum;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int cur;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visit = new boolean[N][N];
            int countHouse = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        countHouse++;
                    }
                }
            }

            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (countHouse == max) {
                        break;
                    }
                    bfs(i, j);
                }
            }
            System.out.println("#" + tc + " " + max);

        }
    }

    public static void bfs(int x, int y) {
        for (int k = 1; k <= N + N; k++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((Math.abs(i - x) + Math.abs(j - y)) <= k - 1) {
                        if (map[i][j] == 1) {
                            cnt++;
                        }
                    }
                }
            }
            int cost = k * k + (k - 1) * (k - 1);
            if (cost <= cnt * M) {
                if (max < cnt)
                    max = cnt;
            }
        }
    }

}
