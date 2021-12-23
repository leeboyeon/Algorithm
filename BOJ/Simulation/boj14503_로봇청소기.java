package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class boj14503_로봇청소기 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;
    static int N, M;
    static int d;
    static int result = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int robotr = Integer.parseInt(st.nextToken());
        int robotc = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dfs(robotr, robotc, d);

        System.out.println(result);
    }

    static void dfs(int r, int c, int d) {
        map[r][c] = 2;

        for (int i = 0; i < 4; i++) {
            d -= 1;
            if (d == -1)
                d = 3;

            int nx = r + dx[d]; // 그방향으로 간다잉
            int ny = c + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == 0) {
                    result++; // 청소하고
                    dfs(nx, ny, d); // 다시돌리고
                    return;
                }
            }
        }

        // 사방이 들렸거나 벽이면 후진해야함
        int nd = (d + 2) % 4; // 후진 d로 변환
        int mx = r + dx[nd]; // 후진하고
        int my = c + dy[nd];
        if (mx >= 0 && mx < N && my >= 0 && my < M && map[mx][my] != 1) {
            dfs(mx, my, d); // 벽아니면 후진가능임
        }
    }

}
