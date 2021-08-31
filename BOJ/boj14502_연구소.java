package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502_연구소 {
    static boolean[][] visit;
    static int col, row, result;
    static int[][] map;
    static int[][] tmp;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        tmp = new int[col][row];
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        setWall(0);
        System.out.println(result);
    }

    public static void setWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    public static void spreadVirus() {
        Queue<Pair> q = new LinkedList<>();
        int[][] tmp = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (tmp[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.row + dx[i];
                int ny = cur.col + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (tmp[nx][ny] == 0) {
                        tmp[nx][ny] = 2;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
        int safe = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (tmp[i][j] == 0) {
                    safe++;
                }
            }
        }
        if (result < safe) {
            result = safe;
        }
    }

}

class Pair {
    int row, col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
