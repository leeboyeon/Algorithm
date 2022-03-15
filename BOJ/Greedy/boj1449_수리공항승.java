package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1449_수리공항승 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        Arrays.sort(arr);
        int count = 0;
        double length = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] + 0.5 > length) {
                count++;
                length = arr[i] - 0.5 + L;
            }
        }

        System.out.println(count);

    }
}
