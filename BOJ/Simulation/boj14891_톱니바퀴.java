package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14891_톱니바퀴 {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][8];
        String[] input = new String[8];

        // N극 0, S극 1
        for (int i = 1; i <= 4; i++) {
            input[i] = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = input[i].charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        // direction : 1 = 시계방향 -1 = 반시계방향
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int lotation = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 7; j++) {
                if (direction == 1) {
                    if (lotation == 4) {
                        map[lotation][j] = map[lotation][j + 1];
                        map[lotation][0] = map[lotation][7];
                        break;
                    }
                    if (map[lotation + 1][j] != map[lotation][j]) {
                        map[lotation][j] = map[lotation][j + 1];
                        map[lotation][0] = map[lotation][7];

                        map[lotation + 1][j] = map[lotation + 1][j + 1];
                        map[lotation + 1][0] = map[lotation + 1][7];
                    } else {
                        map[lotation][j] = map[lotation][j + 1];
                        map[lotation][0] = map[lotation][7];
                    }

                } else {
                    if (lotation == 4) {
                        map[lotation][j + 1] = map[lotation][j];
                        map[lotation][7] = map[lotation][0];
                        break;
                    }
                    if (map[lotation + 1][j] != map[lotation][j]) {
                        map[lotation][j + 1] = map[lotation][j];
                        map[lotation][7] = map[lotation][0];

                        map[lotation + 1][j + 1] = map[lotation + 1][j];
                        map[lotation + 1][7] = map[lotation + 1][0];
                    } else {
                        map[lotation][j + 1] = map[lotation][j];
                        map[lotation][7] = map[lotation][0];
                    }
                }
            }

        }
        int result = 0;
        int step1 = map[1][0];
        int step2 = map[2][0];
        int step3 = map[3][0];
        int step4 = map[4][0];

        if (step1 == 0) {
            result += 0;
        }
        if (step1 == 1) {
            result += 1;
        }

        if (step2 == 0) {
            result += 0;
        }
        if (step2 == 1) {
            result += 2;
        }

        if (step3 == 0) {
            result += 0;
        }
        if (step3 == 1) {
            result += 4;
        }

        if (step4 == 0) {
            result += 0;
        }
        if (step4 == 1) {
            result += 8;
        }

        System.out.println(result);
    }
}
