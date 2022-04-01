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

            checkSide(lotation, direction);
        }
        int result = 0;
        int[] value = { 0, 1, 2, 4, 8 };
        for (int i = 1; i <= 4; i++) {
            if (map[i][0] == 1) {
                result += value[i];
            }
            // result += map[i][0];
        }
        System.out.println(result);

    }

    static void moveTire(int lotation, int direction) {
        if (direction == 1) {
            // 시계방향 회전
            int tmp = map[lotation][7];
            for (int i = 7; i > 0; i--) {
                map[lotation][i] = map[lotation][i - 1];
            }
            map[lotation][0] = tmp;
        } else {
            // 반시계방향 회전
            int tmp = map[lotation][0];
            for (int i = 0; i < 7; i++) {
                map[lotation][i] = map[lotation][i + 1];
            }
            map[lotation][7] = tmp;
        }
    }

    static void checkSide(int lotation, int direction) {
        // 왼쪽 체크
        leftCheck(lotation - 1, -direction);
        rightCheck(lotation + 1, -direction);
        moveTire(lotation, direction);
    }

    static void leftCheck(int lotation, int direction) {
        if (lotation >= 1) {
            if (map[lotation][2] == map[lotation + 1][6])
                return;
            // 한칸더 왼쪽도 확인
            leftCheck(lotation - 1, -direction);
            moveTire(lotation, direction);
        }
    }

    static void rightCheck(int lotation, int direction) {
        if (lotation <= 4) {
            if (map[lotation][6] == map[lotation - 1][2])
                return;
            // 한칸더 오른쪽도 확인
            rightCheck(lotation + 1, -direction);
            moveTire(lotation, direction);
        }
    }
}
