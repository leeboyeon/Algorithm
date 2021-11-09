package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9205_맥주마시면서걸억가기 {
    static int N;
    static ArrayList<Pair> list;
    static int[][] map;
    static int INF = 1000000000;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {

            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            map = new int[N + 2][N + 2];

            for (int i = 0; i < N + 2; i++) {
                Arrays.fill(map[i], INF);
            }

            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Pair(x, y));

            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    if (i == j)
                        continue;
                    Pair cur = list.get(i);
                    Pair next = list.get(j);

                    int distance = Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);
                    if (distance <= 1000) {
                        map[i][j] = 1;
                    }
                }
            }

            for (int via = 0; via < N + 2; via++) {
                for (int from = 0; from < N + 2; from++) {
                    for (int to = 0; to < N + 2; to++) {
                        if (map[from][via] + map[via][to] < map[from][to]) {
                            map[from][to] = map[from][via] + map[via][to];
                        }
                    }
                }
            }

            if (map[0][N + 1] > 0 && map[0][N + 1] < INF) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }

    }
}
