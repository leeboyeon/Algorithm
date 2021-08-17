package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class boj1427_sortInside {
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String[] arr;

        arr = n.split("");

        Arrays.sort(arr);

        for (int i = arr.length - 1; 0 <= i; i--) {
            System.out.print(arr[i]);
        }
    }
}