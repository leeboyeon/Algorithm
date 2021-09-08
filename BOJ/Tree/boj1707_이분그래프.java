package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1707_이분그래프 {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            make();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                pq.add(new Node(a, b));
            }
            if (findcicle() == true) {
                System.out.println(tc + " " + "NO");

            } else {
                System.out.println(tc + " " + "YES");
            }
        }
    }

    public static void make() {
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        } else
            return;
    }

    public static boolean findcicle() {

        int count = 0;
        result = false;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int a = find(cur.from);
            int b = find(cur.to);

            if (a == b) {
                result = true;
            }
            union(a, b);
            if (count + 1 == V) {
                break;
            }

        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return o.from - this.from;
        }

    }
}
