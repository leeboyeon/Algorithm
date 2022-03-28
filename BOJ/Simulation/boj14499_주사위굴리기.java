package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14499_주사위굴리기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int[] coil = new int[7];
        Arrays.fill(coil, 0);
        /**
         * coil[6] == bottom
         * 
         */
        for (int i = 0; i < K; i++) {
            int value = Integer.parseInt(st.nextToken());
            int top = coil[1];

            switch (value) {
                case 1:
                    // 동쪽

                    if (y + 1 < M) {
                        y += 1;
                        coil[1] = coil[4];
                        coil[4] = coil[6];
                        coil[6] = coil[3];
                        coil[3] = top;
                    } else {
                        continue;
                    }

                    break;
                case 2:
                    // 서쪽

                    if (y - 1 >= 0) {
                        y -= 1;
                        coil[1] = coil[3];
                        coil[3] = coil[6];
                        coil[6] = coil[4];
                        coil[4] = top;
                    } else {
                        continue;
                    }

                    break;
                case 3:
                    // 북쪽
                    if (x - 1 >= 0) {
                        x -= 1;
                        coil[1] = coil[5];
                        coil[5] = coil[6];
                        coil[6] = coil[2];
                        coil[2] = top;
                    } else {
                        continue;
                    }

                    break;
                case 4:
                    // 남쪽
                    if (x + 1 < N) {
                        x += 1;
                        coil[1] = coil[2];
                        coil[2] = coil[6];
                        coil[6] = coil[5];
                        coil[5] = top;
                    } else {
                        continue;
                    }

                    break;
            }
            if (map[x][y] == 0) {
                map[x][y] = coil[6];
            } else {
                coil[6] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(coil[1]);
        }

    }
}
