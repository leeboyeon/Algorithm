package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576_tomato {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        bfs(N, M);

    }

    public static void bfs(int N, int M) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[cur.x][cur.y] + 1;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        System.out.println(max - 1);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
