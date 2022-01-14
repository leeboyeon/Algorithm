package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj12101_123더하기2 {
    static int N, K;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[11];

        reculsion(0, 0);

        if (count != K) {
            System.out.println("-1");
        }
    }

    static boolean reculsion(int sum, int idx) {
        if (sum > N) {
            return false;
        }
        if (sum == N) {
            count++;
            if (count == K) {
                for (int i = 0; i < idx - 1; i++) {
                    System.out.print(arr[i] + "+");
                }
                System.out.print(arr[idx - 1]);
                return true;
            }
        }

        for (int i = 1; i <= 3; i++) {
            arr[idx] = i;
            if (reculsion(sum + i, idx + 1)) {
                return true;
            }
        }
        return false;
    }
}
