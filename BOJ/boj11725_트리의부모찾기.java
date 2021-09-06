package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11725_트리의부모찾기 {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i] == false) {
                dfs(i);
            }
        }
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i] + " ");
        }
    }

    public static void dfs(int v) {
        if (visit[v] == true) {
            return;
        }

        visit[v] = true;
        for (int i : list[v]) {
            if (visit[i] == false) {
                parent[i] = v;
                dfs(i);
            }
        }
    }
}
