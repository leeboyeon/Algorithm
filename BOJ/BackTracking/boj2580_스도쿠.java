package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2580_스도쿠 {
    static int[][] map;
    static int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] tmp = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp[i] = map[i][j];
            }
            checkRow(tmp);
        }

    }

    public static void checkRow(int[] arr) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    q.offer(new Pair(i, j, map[i][j]));
                }
            }
        }
    }

    public static void checkCol(int[] map) {

    }

    public static void checkMap(int[] map) {

    }

    static class Pair {
        int x;
        int y;
        int value;

        public Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
