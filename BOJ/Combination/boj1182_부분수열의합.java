package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182_부분수열의합 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        reculsion(arr, N, 0, 0, S);
        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }

    static void reculsion(int[] arr, int N, int idx, int sum, int S) {
        if (idx == N) { // idx = 5
            if (sum == S) {
                count++;
            }
            return;
        }
        // idx == 5;
        reculsion(arr, N, idx + 1, sum, S);
        reculsion(arr, N, idx + 1, sum + arr[idx], S);
        // re(arr,N,5+1,sum+arr[idx],S)
    }
}
