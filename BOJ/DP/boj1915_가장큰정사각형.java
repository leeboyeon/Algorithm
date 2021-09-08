package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1915_가장큰정사각형 {
    static int[][] map;
    static int N, M;
    static int[][] tmp;
    static int result;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tmp = new int[N][M];
        result = 1;
        count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                tmp[i][j] = map[i][j];
                if (map[i][j] == 1) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (map[i - 1][j - 1] > 0 && map[i][j - 1] > 0 && map[i - 1][j] > 0) {
                            map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                            result = Math.max(result, map[i][j]);
                        }
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("0");
        } else if (count == 1) {
            System.out.println("1");
        } else {
            System.out.println(result * result);
        }

    }
}
