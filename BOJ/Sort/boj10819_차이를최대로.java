package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj10819_차이를최대로 {
    static int N;
    static int[] a;
    static boolean[] visit;
    static int[] check;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        visit = new boolean[N];
        check = new int[N];
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            a[i] = value;
        }

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            int tmp = calcul();
            result = Math.max(result, tmp);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                check[cnt] = a[i];
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }

    static int calcul() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(check[i] - check[i + 1]);
        }
        return sum;
    }
}
