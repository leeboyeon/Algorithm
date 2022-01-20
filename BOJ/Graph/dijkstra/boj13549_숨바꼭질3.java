package BOJ.Graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj13549_숨바꼭질3 {
    static int N, K;
    static int[] dx = { -1, 1 };
    static boolean[] visit;
    static Queue<Pair> q;
    static int min = Integer.MAX_VALUE;
    // N의 최댓값은 100000이다.
    static int INF = 100000;

    static class Pair {
        int to;
        int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // <= 100000이기때문에 +1해주기
        visit = new boolean[INF + 1];
        bfs();
        System.out.println(min);
    }

    static void bfs() {
        q = new LinkedList<>();
        q.offer(new Pair(N, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            visit[cur.to] = true;
            // 도착했을때의 최소시간..최소비용
            if (cur.to == K) {
                min = Math.min(min, cur.cost);
            }
            // 수빈이는 순간이동도 한다. cost는 변하지 않고 이동만 가능함.
            if (cur.to * 2 <= INF && visit[cur.to * 2] == false) {
                q.offer(new Pair(cur.to * 2, cur.cost));
            }
            // 수빈이의 위치는 X+1로 이동할수있다. 단, 방문하지 않았어야 함

            if (cur.to + 1 <= INF && visit[cur.to + 1] == false) {
                q.offer(new Pair(cur.to + 1, cur.cost + 1));
            }
            // 수빈이는 위치를 x-1로도 갈수있다. 단, 방문하지 않았어야 함
            if (cur.to - 1 >= 0 && visit[cur.to - 1] == false) {
                q.offer(new Pair(cur.to - 1, cur.cost + 1));
            }
        }
    }
}
