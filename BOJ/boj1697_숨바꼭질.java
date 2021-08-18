package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697_숨바꼭질 {
    static int N, K;
    static int[] visit;

    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visit[end] != 0)
                break;
            if ((cur - 1 >= 0) && visit[cur - 1] == 0) {
                q.offer(cur - 1);
                visit[cur - 1] = visit[cur] + 1;
            }
            if ((cur < visit.length - 1) && visit[cur + 1] == 0) {
                q.offer(cur + 1);
                visit[cur + 1] = visit[cur] + 1;
            }
            if ((cur * 2 < visit.length) && visit[cur * 2] == 0) {
                q.offer(cur * 2);
                visit[cur * 2] = visit[cur] + 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new int[100001];

        if (N == K) {
            System.out.println("0");
            return;
        }
        bfs(N, K);

        System.out.println(visit[K]);
    }
}
