package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4012_요리사 {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void dfs(int count, int index) {
        int teamA = 0;
        int teamB = 0;
        int result = 0;
        if (count == N / 2) {
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visit[i] == true && visit[j] == true) {
                        teamA += map[i][j] + map[j][i];
                    } else if (visit[i] == false && visit[j] == false) {
                        teamB += map[i][j] + map[j][i];
                    }
                }
            }
            result = Math.abs(teamA - teamB);
            min = Math.min(min, result);
            return;
        }

        for (int i = index; i < N; i++) {
            visit[i] = true;
            dfs(count + 1, i + 1);
            visit[i] = false;
        }
    }

}
