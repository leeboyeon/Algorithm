package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3190_뱀 {
    static int N, K, L;
    static int[][] map;
    static int[][] dir;
    // static int checked = 1;
    static Queue<Pair> head;
    static Queue<Pair> tail;
    static PriorityQueue<Dir> checked;
    static boolean[][] visit;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    /**
     * 
     * @param args
     * @throws Exception
     * 
     *                   2 : 사과
     *                   checked = 1>Right 2> Left 3>Top 4>Bottom
     */
    static public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public class Dir implements Comparable<Dir> {
        int time;
        int direction;

        public Dir(int time, int direction) {
            this.time = time;
            this.direction = direction;
        }

        @Override
        public int compareTo(Dir o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            Arrays.fill(map[i], 0);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            map[col][row] = 2;
        }

        L = Integer.parseInt(br.readLine());
        checked = new PriorityQueue<>();
        checked.offer(new Dir(0, 0));
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int direction = 0;
            if (st.nextToken().charAt(0) == 'L') {
                direction = 2;
            } else if (st.nextToken().charAt(0) == 'D') {
                direction = 1;
            }

            checked.offer(new Dir(time, direction));
        }
        bfs();
    }

    static void bfs() {
        head = new LinkedList<>();
        head.offer(new Pair(1, 1));
        int time = 0;
        int tmpx = 0;
        int tmpy = 0;
        int move = 0;
        while (true) {
            int nx = tmpx + dx[move];
            int ny = tmpy + dy[move];
            time++;

            if (nx < 1 || ny < 1 || nx > N || ny > N)
                break;
            if (map[nx][ny] == 2) {
                map[nx][ny] = 0;
                head.offer(new Pair(nx, ny));
            } else {
                head.offer(new Pair(nx, ny));
                head.poll();
            }
            Dir curCheck = checked.poll();
            if (curCheck.time == time) {
                if (curCheck.direction == 2) {
                    move -= 1;
                    if (move == -1)
                        move = 3;
                } else {
                    move += 1;
                    if (move == 4)
                        move = 0;
                }
            }

            tmpx = nx;
            tmpy = ny;
        }

        System.out.println(time);
    }
}
