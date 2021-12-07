package SWEA.Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_battle_no3 {
    static int[][] sea;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sea = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < C; j++) {
                    sea[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int time = 0;
            int depth = 0;
            int count = 0;
            int totalTime = 0;
            for (int i = 0; i < R; i++) {
                if (depth == R - 1) {
                    break;
                }
                for (int j = 0; j < C; j++) {
                    time++;
                    if (sea[depth][j] == 1) {
                        time++;
                        sea[depth][j] = 0;
                        depth++;
                    } else {
                        count++;
                    }
                }

                if (count == C) {
                    time = 0;
                    break;
                }
                count = 0;
                totalTime += time;
                time = 0;
            }

            System.out.println("#" + tc + " " + totalTime);
        }

    }
}
