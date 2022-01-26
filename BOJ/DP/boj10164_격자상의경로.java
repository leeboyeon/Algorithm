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
        } else {
            int x = K % M - 1;
            if (x < 0)
                x = M - 1;

            int y = K / M;

            if (K % M == 0)
                y--;
            int route1 = solution(x, y); // 중간점까지값
            int route2 = solution(M - x - 1, N - y - 1); // 중간점 - 도착지 값

            System.out.println(route1 * route2);
        }
    }

    static int solution(int X, int Y) {

        int[][] dp = new int[Y + 1][X + 1];

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
