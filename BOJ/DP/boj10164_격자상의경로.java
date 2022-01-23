package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10164_격자상의경로 {
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K == 0) {
            System.out.println(solution(N - 1, M - 1));
            return;
        } else {
            int y = K / M;
            int x = K % M - 1;
            if (x < 0)
                x = M - 1;
            if (K % M == 0)
                y--;
            int route1 = solution(x, y);
            int route2 = solution(N - x - 1, M - y - 1);

            System.out.println(route1 * route2);
            return;
        }
    }

    static int solution(int X, int Y) {

        int[][] dp = new int[X + 1][Y + 1];

        for (int i = 1; i < X + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < Y + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < Y + 1; j++) {
            for (int i = 1; i < X + 1; i++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }

        return dp[Y][X];
    }
}
