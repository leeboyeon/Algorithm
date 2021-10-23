package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.text.DefaultStyledDocument;

public class boj14501_퇴사 {
    static int result;
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        dfs(0, 0);
        System.out.println(result);

    }

    public static void dfs(int index, int value) {
        if (index >= N) {
            result = Math.max(result, value);
            return;
        }
        if (index + map[index][0] <= N) {
            dfs(index + map[index][0], value + map[index][1]);
        } else {
            dfs(index + map[index][0], value);
        }
        dfs(index + 1, value);
    }
}
