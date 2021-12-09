package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1929_소수구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            int j;
            for (j = 2; j * j <= i; j++) {
                if (i % j == 0)
                    break;
            }

            if (j * j > i) {
                if (i != 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
