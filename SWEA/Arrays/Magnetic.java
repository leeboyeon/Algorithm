package SWEA.Arrays;

import java.util.Scanner;

public class Magnetic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            int there = 0;

            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size; i++) {
                    if (arr[i][j] == 1) {
                        there = 1;
                    } else if (there == 1 && arr[i][j] == 2) {
                        there = 0;
                        count++;
                    }
                }
                there = 0;
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
