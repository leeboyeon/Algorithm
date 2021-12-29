package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18429_근손실운동 {
    static int N;
    static int K;
    static int[] arr;
    static boolean[] visit;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];

        result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            int value = tmp - K;
            arr[i] = value;
        }

        solution(0, 0);
        System.out.println(result);
    }

    static void solution(int cnt, int sum) {
        if (cnt == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i] && sum + arr[i] >= 0) {
                visit[i] = true;
                solution(cnt + 1, sum + arr[i]);
                visit[i] = false;
            }
        }
    }
}
