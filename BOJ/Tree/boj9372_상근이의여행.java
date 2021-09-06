package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class boj9372_상근이의여행 {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            visit = new boolean[N + 1];

            for (int i = 0; i < N + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }
            System.out.println(FindMin());
        }
    }

    public static int FindMin() {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list[cur]) {
                if (visit[i] == false) {
                    q.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
