package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15723_n단논법 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[51][51];
        int cnt = 2;
        while (cnt-- > 0) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                String[] value = str.split(" ");
                String value1 = value[0];
                String value2 = value[2];

                arr[value1.charAt(0) - 'a'][value2.charAt(0) - 'a'] = 1;
            }

            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    System.out.println(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}
