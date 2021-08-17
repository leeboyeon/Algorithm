package SWEA.Arrays;

import java.util.Scanner;

public class ModeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            int[] arr = new int[1000];

            for (int j = 0; j < 1000; j++) {
                arr[j] = sc.nextInt();
            }
            int[] cntarr = new int[101];

            for (int j = 0; j < 1000; j++) {
                cntarr[arr[j]]++;
            }

            int result = 0;
            int tmp = 0;

            for (int k = 100; k >= 0; k--) {
                if (result < cntarr[k]) {
                    result = cntarr[k];
                    tmp = k;
                }
            }

            System.out.println("#" + i + " " + tmp);

        }

    }
}
