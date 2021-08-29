package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea2005_파스칼의삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            System.out.println("#" + tc + " ");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = 1;
                    if (i > 1 && j >= 1) {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                        if (i == j) {
                            arr[i][j] = 1;
                        }
                    }
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }

        }

    }
}
