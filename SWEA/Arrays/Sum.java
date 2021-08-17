package SWEA.Arrays;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100];

        for (int k = 1; k <= 10; k++) {
            int max = 0;
            int sum = 0;
            int T = sc.nextInt();

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 행
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                if (max < sum)
                    max = sum;
                sum = 0;
            }

            // 열
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 100; i++) {
                    sum += arr[i][j];
                }
                if (max < sum)
                    max = sum;
                sum = 0;
            }

            // 대각선
            for (int i = 0; i < 100; i++) {
                sum += arr[i][i];
            }
            if (max < sum)
                max = sum;
            sum = 0;

            for (int i = 99, j = 0; i >= 0; i--, j++) {
                sum += arr[i][j];
            }
            if (max < sum)
                max = sum;

            System.out.println("#" + k + " " + max);
        }

    }
}
