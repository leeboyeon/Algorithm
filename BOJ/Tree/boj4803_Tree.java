package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj4803_Tree {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            int ans = 0;
            tree = new ArrayList[N];
            visit = new boolean[N];

            for (int i = 0; i < N; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree[a].add(b);
                tree[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    if (dfs(-1, i))
                        ans++;
                }
            }

            System.out.print("Case" + T++ + ": ");
            if (ans == 0) {
                System.out.println("No trees.");
            } else if (ans == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + ans + " trees.");
            }
        }

    }

    public static boolean dfs(int root, int num) {
        for (int i : tree[num]) {
            if (i == root)
                continue;
            if (visit[i])
                return false;
            visit[i] = true;
            if (!dfs(num, i))
                return false;
        }
        return true;
    }
}
