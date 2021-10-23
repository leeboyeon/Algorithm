package BOJ.DividConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630_색종이만들기 {
    static int N;
    static int[][] map;
    static int[] count = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        div(N, 0, 0);
        for (int i : count) {
            System.out.println(i);
        }
    }

    public static void div(int size, int y, int x) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != map[y][x]) {
                    div(size / 2, y, x);
                    div(size / 2, y + size / 2, x);
                    div(size / 2, y, x + size / 2);
                    div(size / 2, y + size / 2, x + size / 2);

                    return;
                }
            }
        }
        count[map[y][x]]++;
    }
}
