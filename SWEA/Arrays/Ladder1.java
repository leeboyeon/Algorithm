package SWEA.Arrays;

import java.util.Scanner;

public class Ladder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int[][] arr = new int[100][100];
            int T = sc.nextInt();
            int x = 0, y = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 2) {
                        x = j;
                        y = i;
                    }
                }
            }

            while (true) {
                if (y - 1 < 0)
                    break;
                else {
                    if (x - 1 >= 0 && arr[y][x - 1] == 1) {
                        arr[y][x] = 0;
                        x--;
                    } else if (x + 1 < 100 && arr[y][x + 1] == 1) {
                        arr[y][x] = 0;
                        x++;
                    } else if (arr[y - 1][x] == 1) {
                        arr[y][x] = 0;
                        y--;
                    }
                }
            }
            System.out.println("#" + test_case + " " + x);
        }
    }
}
