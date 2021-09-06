package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1197_MST {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        result = 0;
        make();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        result = dfs();
        System.out.println(result);
    }

    public static void make() {
        // 상위노드를 초기화
        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        // 부모노드를 찾음
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        // 최상위 노드를 합치는 함수 no Cicle
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        } else
            return;
    }

    public static int dfs() {
        int sumWeight = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int a = find(cur.start);
            int b = find(cur.end);

            if (a == b) {
                // this is cicle.
                continue;
            }
            union(a, b);
            sumWeight += cur.weight;
            if (count + 1 == V) {
                break;
            }
        }
        return sumWeight;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return o.weight >= this.weight ? -1 : 1;
    }
}
