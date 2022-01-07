package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11051_이항계수2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] comb = new int[N + 1][N + 1];

        comb[0][0] = comb[1][0] = comb[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i && j <= K; j++) {
                if (i == j || j == 0)
                    comb[i][j] = 1;
                else {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                }
                comb[i][j] %= 10007;

            }
        }

        System.out.println(comb[N][K]);
    }
}
