package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1436_영화감독숌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int title = 666;
        int cnt = 1;

        while (cnt != N) {
            title++;
            if (String.valueOf(title).contains("666")) {
                cnt++;
            }
        }

        System.out.println(title);
    }
}
