package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2805_농작물수확하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] bat = new int[N][N];

            String[] str = new String[N];
            for (int i = 0; i < N; i++) {
                str = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    bat[i][j] = Integer.parseInt(str[j]);
                }
            }

            int middle = N / 2;
            int top = 0;
            for (int i = 0; i <= middle; i++) {
                for (int j = middle - i; j <= middle + i; j++) {
                    top += bat[i][j];
                }
            }
            int a = 1;
            for (int i = middle + 1; i < N; i++) {
                for (int j = a; j <= N - 1 - a; j++) {
                    top += bat[i][j];
                }
                a++;
            }
            System.out.println("#" + tc + " " + top);
        }

    }

}
