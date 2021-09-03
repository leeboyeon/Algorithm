package SWEA.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea1258_행렬찾기 {
    static int N;
    static int[][] map;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean visit[][];
    static boolean check[][];
    static ArrayList<Pair> list;
    static int count;

    public static void main(String[] ags) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.print("#" + tc + " ");
            solve();
        }
    }

    public static void solve() {
        count = 0; // 배열 갯수
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false && map[i][j] != 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == true && check[i][j] == false) {
                    int r = 0;
                    int c = 0;
                    while (true) {

                        if (i + r < N && visit[i + r][j] == true) {
                            r++;
                        } else
                            break;

                    }
                    while (true) {

                        if (j + c < N && visit[i][j + c] == true) {
                            c++;
                        } else
                            break;

                    }
                    for (int a = i; a < i + r; a++) {
                        for (int b = j; b < j + c; b++) {
                            check[a][b] = true;
                        }
                    }
                    list.add(new Pair(r, c, r * c));
                } else
                    continue;

            }

        }
        System.out.print(count + " ");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).x + " " + list.get(i).y + " ");
        }
        System.out.println();
    }

    public static void dfs(int x, int y) {

        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (visit[nx][ny] == false && map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

}

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int size;

    public Pair(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.size > p.size) {
            return 1;
        } else
            return -1;
    }
}