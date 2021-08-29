package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001_파리퇴치 {
    static int[][] pari;
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int a = 0; a < M; a++) {
                        for (int b = 0; b < M; b++) {
                            if (i + a >= 0 && i + a < N && j + b >= 0 && j + b < N) {
                                sum += map[i + a][j + b];
                            }
                        }
                    }
                    max = Math.max(max, sum);
                    sum = 0;

                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }

}
