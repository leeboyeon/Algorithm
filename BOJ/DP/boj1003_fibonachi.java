package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1003_fibonachi {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            fibo(N);
            System.out.println(memo[0] + " " + memo[1]);
        }
    }

    public static void fibo(int N) {
        memo = new int[51];
        int zcnt = 0;
        int ocnt = 0;
        memo[0] = zcnt++;
        memo[1] = ocnt++;

        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

    }
}
