package SWEA.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1247_최적경로 {
    static int hx;
    static int hy;
    static int cx;
    static int cy;
    static int N;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 2][2];
            visit = new boolean[N + 2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N + 2; i++) {
                // company
                map[0][0] = Integer.parseInt(st.nextToken());
                map[0][1] = Integer.parseInt(st.nextToken());

                // home
                map[N + 1][0] = Integer.parseInt(st.nextToken());
                map[N + 1][1] = Integer.parseInt(st.nextToken());

                for (int j = 1; j <= N; j++) {
                    map[j][0] = Integer.parseInt(st.nextToken());
                    map[j][1] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(map, 0, visit, 0);
        }
    }

    public static void dfs(int[][] map, int count, boolean[] visit, int sum) {
        visit[count] = true;
        if (count == N + 1) {
            for (int i = 1; i <= N; i++) {
                sum += Math.abs(map[i][0] - map[i + 1][0]) + Math.abs(map[i][1] - map[i + 1][1]);
            }
            System.out.println(sum);
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i] == false) {
                int curx = map[count][0];
                int cury = map[count][1];

                int gox = map[i][0];
                int goy = map[i][1];

                int distance = Math.abs(curx - gox) + Math.abs(cury - goy);

                dfs(map, count + 1, visit, sum);
            }
        }
    }

}
