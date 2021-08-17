package SWEA.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        for (int i = 1; i <= 10; i++) {
            int dumpcnt = sc.nextInt();
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int j = 0; j < dumpcnt; j++) {
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }
            System.out.println("#" + i + " " + (arr[99] - arr[0]));
        }
        sc.close();
    }
}
