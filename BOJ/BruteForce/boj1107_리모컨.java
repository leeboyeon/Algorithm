package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1107_리모컨 {
    static int N;
    static int M;
    static int[] button;
    static boolean[] broken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        button = new int[M];
        broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            broken[value] = true;
        }
        if (N == 100) {
            System.out.println(0);
            return;
        }

        int start = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String tmp = String.valueOf(i);
            int size = tmp.length();

            boolean flag = false;
            for (int j = 0; j < size; j++) {
                if (broken[tmp.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int min = Math.abs(N - i) + size;
                start = Math.min(min, start);
            }
        }
        System.out.println(start);
    }
}
