package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj2108_통계학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        double sum = 0;
        for (double value : arr) {
            sum += value;
        }
        System.out.println((int) Math.round(sum / N));

        // 중앙값
        Arrays.sort(arr);
        System.out.println((int) arr[N / 2]);

        // 최빈값
        int[] tmp = new int[8001];
        for (double value : arr) {
            tmp[(int) value + 4000]++;
        }
        int max = 0;
        int max_idx = 0;
        for (int i = 0; i < 8001; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        boolean two = false;
        for (int i = 0; i < 8001; i++) {
            if (tmp[i] == max) {
                if (two) {
                    max_idx = i - 4000;
                    break;
                }
                max_idx = i - 4000;
                two = true;
            }
        }

        System.out.println(N == 1 ? (int) arr[0] : max_idx);

        // 범위
        System.out.println((int) arr[N - 1] - arr[0]);
    }
}
