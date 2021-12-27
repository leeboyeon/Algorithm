package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15658_연산자끼워넣기2 {
    static int N;
    static int[] arr;
    static int[] op;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        op = new int[4];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int cnt, int result) {
        if (cnt == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] <= 0)
                continue;

            op[i]--;
            int tmp = result;
            if (i == 0) {
                tmp += arr[cnt];
                dfs(cnt + 1, tmp);
            }

            if (i == 1) {
                tmp -= arr[cnt];
                dfs(cnt + 1, tmp);
            }

            if (i == 2) {
                tmp *= arr[cnt];
                dfs(cnt + 1, tmp);
            }
            if (i == 3) {
                tmp /= arr[cnt];
                dfs(cnt + 1, tmp);
            }
            op[i]++;
        }
    }

}
