package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2004_조합0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] comb = new long[N + 1][N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i && j <= K; j++) {
                if (i == j || j == 0) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                }
            }
        }
        String result = String.valueOf(comb[N][K]);
        int zero = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            int value = result.charAt(i) - '0';
            if (value == 0) {
                zero++;
            }
            if (value != 0) {
                System.out.println(zero);
                break;
            }
        }

    }
}
