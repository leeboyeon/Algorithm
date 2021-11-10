package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2458_키순서 {
    static int N;
    static int M;
    static int[][] map;
    static int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
        }

        for (int via = 1; via < N + 1; via++) {
            for (int from = 1; from < N + 1; from++) {
                for (int to = 1; to < N + 1; to++) {
                    if (from == to)
                        continue;
                    if (map[via][to] + map[from][via] < map[from][to]) {
                        map[from][to] = map[via][to] + map[from][via];
                    }
                }
            }
        }
        int count = 0;
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            count = 0;
            for (int j = 1; j < N + 1; j++) {
                // System.out.print(map[i][j] + " ");
                if (map[i][j] != INF || map[j][i] != INF)
                    count++;
            }
            if (count == N - 1) {
                answer++;
            }
            // System.out.println();

        }

        // System.out.println(count);
        System.out.println(answer);

    }
}
