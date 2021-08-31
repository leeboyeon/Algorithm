package SWEA.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1247_최적경로 {
    static int homeX;
    static int homeY;
    static int companyX;
    static int companyY;
    static int N;
    static int sum;
    static int[][] map;
    static int[][] tmp;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][2];
            tmp = new int[N][2];
            visit = new boolean[N];
            min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            companyX = Integer.parseInt(st.nextToken());
            companyY = Integer.parseInt(st.nextToken());

            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void dfs(int count) {

        if (count == N) {
            int sum = getDistance(companyX, companyY, tmp[0][0], tmp[0][1]);
            for (int i = 0; i < tmp.length - 1; i++) {
                sum += getDistance(tmp[i][0], tmp[i][1], tmp[i + 1][0], tmp[i + 1][1]);
            }
            sum += getDistance(tmp[N - 1][0], tmp[N - 1][1], homeX, homeY);
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            tmp[count][0] = map[i][0];
            tmp[count][1] = map[i][1];
            visit[i] = true;
            dfs(count + 1);
            visit[i] = false;
        }
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
