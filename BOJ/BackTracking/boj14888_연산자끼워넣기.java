package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888_연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int[] op;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calcul(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void calcul(int value, int idx) {
        if (idx == N) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
            return;
        }

        int check = 0;

        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i]--;
                if (i == 0) {
                    // +
                    check = value + arr[idx];
                }
                if (i == 1) {
                    // -
                    check = value - arr[idx];
                }
                if (i == 2) {
                    // *
                    check = value * arr[idx];
                }
                if (i == 3) {
                    // /
                    if (value < 0 && arr[idx] > 0) {
                        value = value * -1;
                        check = value / arr[idx];
                        check = check * -1;
                    } else {
                        check = value / arr[idx];
                    }

                }
                calcul(check, idx + 1);
                op[i]++;
            }

        }
    }
}
