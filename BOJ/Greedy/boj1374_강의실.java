package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1374_강의실 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Pair(num, start, end));
        }
        int count = 0;
        int start = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.start > start) {
                count++;
                start = cur.start;
            }
            // else {
            // pq.offer(cur);
            // }
        }

        System.out.println(count);
    }

    static class Pair implements Comparable<Pair> {
        int num;
        int start;
        int end;

        public Pair(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.end - o.end;
        }
    }
}
