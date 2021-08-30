package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea5603_건초더미 {
    static int count = 0;
    static int[] arr;
    static int N;
    static int max = 0;
    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            while (true) {
                find(max, min, arr);
                if (arr[0] == arr[N - 1]) {
                    System.out.println(count - 1);
                    break;
                }
            }

        }
    }

    public static void find(int max, int min, int[] arr) {
        Arrays.sort(arr);
        min = arr[0];
        max = arr[N - 1];
        min++;
        max--;
        arr[0] = min;
        arr[N - 1] = max;
        count++;
    }
}
