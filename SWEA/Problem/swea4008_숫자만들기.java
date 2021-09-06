package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4008_숫자만들기 {
    static int[] op;
    static int[] num;
    static int N;
    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            op = new int[4];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            calcul(1, num[0]);
            System.out.println("#" + tc + " " + (max - min));
        }

    }

    public static void calcul(int count, int result) {
        if (count == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] != 0) {
                op[i]--;
                if (i == 0) {
                    calcul(count + 1, result + num[count]);
                } else if (i == 1) {
                    calcul(count + 1, result - num[count]);
                } else if (i == 2) {
                    calcul(count + 1, result * num[count]);
                } else if (i == 3) {
                    calcul(count + 1, result / num[count]);
                }
                op[i]++;
            }
        }
    }
}
