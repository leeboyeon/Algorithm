package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178_미로찾기 {
    static int[][] map;
    static int N, M;
    static int[][] visit;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[N][M];
        String[] str = new String[N];
        result = 1;
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str[i].charAt(j) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visit[0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curx = node.x;
            int cury = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visit[nx][ny] == 0 && map[nx][ny] == 1) {
                        q.add(new Node(nx, ny));
                        visit[nx][ny] = visit[curx][cury] + 1;
                    }
                }
            }
        }
        System.out.println(visit[N - 1][M - 1]);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
