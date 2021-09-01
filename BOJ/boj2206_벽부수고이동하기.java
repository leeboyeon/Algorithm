package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206_벽부수고이동하기 {
    static int[][] map;
    static int[][] visit;
    static int N, M;
    static int result;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[N][M];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str[i].charAt(j) - '0';
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Node2> q = new LinkedList<>();
        q.add(new Node2(0, 0, 1));
        visit[0][0] = 1;
        Outer: while (!q.isEmpty()) {
            Node2 node = q.poll();
            int curx = node.x;
            int cury = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                    if (visit[nx][ny] == 0) {
                        if (map[nx][ny] == 0) {
                            q.add(new Node2(nx, ny, node.count));
                            visit[nx][ny] = visit[curx][cury] + 1;
                        } else if (map[nx][ny] == 1 && node.count > 0) {
                            map[nx][ny] = 0;
                            q.add(new Node2(nx, ny, 0));
                            visit[nx][ny] = visit[curx][cury] + 1;
                        } else if (map[nx][ny] == 1 && node.count == 0) {
                            System.out.println("-1");
                            break Outer;
                        }
                    }
                }
            }
        }

        System.out.println(visit[N - 1][M - 1]);

    }
}

class Node2 {
    int x;
    int y;
    int count;

    public Node2(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
