package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class boj16562_친구비 {
    static int n, m, k;
    static int[] parent;
    static int[] cost;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // graph = new int[n + 1][n + 1];
        cost = new int[n + 1];
        parent = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            union(v1, v2);
        }
        int min = 0;
        for (int i = 1; i < n + 1; i++) {
            int cur = cost[i];
            if (visit[i] == true)
                continue;
            for (int j = 1; j < n + 1; j++) {
                if (find(i) == find(j)) {
                    cur = Math.min(cur, cost[j]);
                    visit[j] = true;
                }
            }
            min += cur;
            visit[i] = true;
        }

        if (min <= k) {
            System.out.println(min);
        } else {
            System.out.println("Oh no");
        }
    }

    // 들어온 value 값의 원소가 포함된 트리의 루트노드를 찾는다.
    static int find(int value) {
        // value의 루트노드가 value 일경우 즉 연결된 노드가 없다.
        if (value == parent[value])
            return value;
        return parent[value] = find(parent[value]);
    }

    // 합치기 : a와 b가 속ㅎ한 그래프를 하나로 합친다 union(합집합) 두개의 루트노드를 찾고 원속값이 더 작은 루트노드를 루트노드로
    // 선택.
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;
        parent[aRoot] = bRoot;

        return true;
    }
}
