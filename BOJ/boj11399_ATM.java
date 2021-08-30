package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int[] tmp = new int[N];
        Arrays.sort(arr);
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                sum += arr[i];
            }
            tmp[j] = sum;
            sum = 0;
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += tmp[i];
        }
        System.out.println(result);

    }
}
