package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234_인구이동 {
    static int[][] arr;
    static int N, L, R;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<Pair> q;
    static ArrayList<Pair> list;
    static boolean[][] visit;
    static int tmp = 0;
    static int result = 0;

    static public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = move();
        System.out.println(answer);
    }

    public static int move() {
        result = 0;
        while (true) {
            boolean isMove = false;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j])
                        continue;
                    if (bfs(i, j))
                        isMove = true;

                }
            }

            if (!isMove) {
                return result;
            } else {
                result++;
            }

        }
    }

    public static boolean bfs(int i, int j) {
        q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Pair(i, j));
        list.add(new Pair(i, j));

        visit[i][j] = true;
        tmp = arr[i][j];

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.a + dx[k];
                int ny = cur.b + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == false) {
                    int avg = Math.abs(arr[cur.a][cur.b] - arr[nx][ny]);

                    if (avg >= L && avg <= R) {
                        q.offer(new Pair(nx, ny));
                        list.add(new Pair(nx, ny));

                        tmp += arr[nx][ny];
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        if (list.size() == 1)
            return false;
        else {
            // 인구변경시도
            int avg = tmp / list.size();
            for (Pair cur : list) {
                arr[cur.a][cur.b] = avg;
            }
            return true;
        }
    }

}
