package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2004_조합0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long two = 0;
        long five = 0;

        two = getCount(N, 2) - getCount(K, 2) - getCount((N - K), 2);
        five = getCount(N, 5) - getCount(K, 5) - getCount((N - K), 5);

        long result = Math.min(two, five);
        System.out.println(result);
    }

    public static long getCount(int N, int value) {
        long count = 0;
        for (int i = value; i <= N; i += value) {
            int tmp = i;

            while (tmp != 0 && tmp % value == 0) {
                count++;
                tmp /= value;
            }
        }

        return count;
    }
}
