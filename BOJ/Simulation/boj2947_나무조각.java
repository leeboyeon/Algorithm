package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2947_나무조각 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int[] reverse = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            reverse[i] = arr[i];
        }
        Arrays.sort(reverse);
        int tmp = 0;
        int cnt = 0;
        Outer: while (true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    cnt = 0;
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    print(arr);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == reverse[i]) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                break Outer;
            }
        }
    }

    public static void print(int[] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i] + " ");
        }
        System.out.println();
    }
}
