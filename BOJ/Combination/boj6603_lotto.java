package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6603_lotto {
    static int[] arr;
    static int[] comb;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = -1;
        int tc = 0;
        while (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];
            comb = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (tc > 0) {
                System.out.println();
            }
            recur(0, 0);
            tc++;
        }
    }

    /**
     * 6개를 골라야한다.
     * 순서가 상관없으면 조합
     * 순서가 상관있으면 순열
     * 
     * @param arr
     * @param N
     * @param k
     */
    public static void recur(int count, int start) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(comb[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            comb[count] = arr[i];
            recur(count + 1, i + 1);
        }
    }
}
