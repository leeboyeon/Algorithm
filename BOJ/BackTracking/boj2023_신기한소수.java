package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2023_신기한소수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        reculusion(0, N);

    }

    static void reculusion(int idx, int N) {
        if (N == 0) {
            if (isPrime(idx)) {
                System.out.println(idx);
                return;
            }
        }
        for (int i = 0; i < 10; i++) {
            int count = idx * 10 + i;
            if (isPrime(count)) {
                reculusion(count, N - 1);
            }
        }
    }

    static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0)
                return false;
        }

        return true;
    }
}
