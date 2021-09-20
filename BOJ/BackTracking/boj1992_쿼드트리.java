package BOJ.BackTracking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1992_쿼드트리 {
    static int N;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str[i].charAt(j) - '0';
            }
        }
        archiveFile(0, 0, N);
    }

    public static void archiveFile(int x, int y, int size) {

        boolean flag = true;
        for (int i = x; i <= x + size; i++) {
            for (int j = y; j <= j + size; j++) {
                if (map[i][j] != map[x][y]) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println(map[x][y]);
        } else {
            System.out.print("(");
            int nextSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    archiveFile(x + nextSize * i, y + nextSize * j, nextSize);
                }
            }
            System.out.println(")");
        }
    }
}
