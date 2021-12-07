package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2660_회장뽑기 {
    static int N;
    static int[][] map;
    static int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(map[i], INF);
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (map[via][to] + map[from][via] < map[from][to]) {
                        map[from][to] = map[via][to] + map[from][via];
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (map[i][i] != INF) {
                count++;
            }

        }
        System.out.println(count);
    }
}
