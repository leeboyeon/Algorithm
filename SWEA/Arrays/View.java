package SWEA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= T; i++) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int j = 0; j < num; j++) {
                arr[j] = sc.nextInt();
            }
            int cnt = 0;
            for (int j = 2; j < num - 2; j++) {
                int max = Math.max(arr[j - 2], Math.max(arr[j - 1], Math.max(arr[j + 1], arr[j + 2])));
                if (arr[j] - max > 0)
                    cnt += arr[j] - max;
            }
            System.out.println("#" + i + " " + cnt);
        }
    }
}
