package BOJ.BruteForce;

import java.util.Scanner;

public class boj2231_분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        int min = Integer.MAX_VALUE;
        boolean check = false;
        for (int i = 0; i < result; i++) {
            String[] num = Integer.toString(i).split("");

            int sum = i;
            for (int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
            }
            if (sum == result) {
                min = Math.min(min, i);
                check = true;
            }
        }
        if (check)
            System.out.println(min);
        else
            System.out.println(0);
    }
}
