package BOJ.BackTracking;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1992_쿼드트리 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<String> list = new ArrayList<>();

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
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public static void archiveFile(int x, int y, int size) {

        boolean flag = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[y + i][x + j] != map[y][x]) {
                    list.add("(");
                    archiveFile(x, y, size / 2);
                    archiveFile(x + size / 2, y, size / 2);
                    archiveFile(x, y + size / 2, size / 2);
                    archiveFile(x + size / 2, y + size / 2, size / 2);
                    list.add(")");
                    return;
                }
            }
        }

        list.add(String.valueOf(map[y][x]));
    }
}
