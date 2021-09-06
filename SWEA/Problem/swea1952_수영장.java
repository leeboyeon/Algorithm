package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1952_수영장 {
    static int[] minCost;
    static int[] cost;
    static int[] day;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            cost = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            day = new int[13];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < 13; i++) {
                day[i] = Integer.parseInt(st.nextToken());
            }
            result = cost[3];
            dfs(1, 0);
            System.out.println("#" + tc + " " + result);
        }

    }

    public static void dfs(int month, int total) {

        if (month > 12) {
            result = Math.min(result, total);
            return;
        }
        if (month == 1) {
            dfs(month + 12, total + cost[3]);
        }
        dfs(month + 1, total + day[month] * cost[0]);
        dfs(month + 1, total + cost[1]);
        dfs(month + 3, total + cost[2]);
    }
}
