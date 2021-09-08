package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1707_BipartiteGraph {
    static int V, E;
    static ArrayList<ArrayList<Integer>> list;
    static int[] color;
    static boolean check;
    static int RED = 1;
    static int BLUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            color = new int[V + 1];
            check = true;
            // init
            for (int i = 0; i < V + 1; i++) {
                list.add(new ArrayList<Integer>());
                color[i] = 0;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                list.get(v2).add(v1);
            }

            for (int i = 1; i < V + 1; i++) {
                if (!check) {
                    break;
                }
                if (color[i] == 0) {
                    bfs(i, RED);
                }
            }
            if (check == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static void bfs(int index, int colors) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(index);
        color[index] = colors;
        while (!q.isEmpty() && check) {
            int cur = q.poll();
            for (int i : list.get(cur)) {
                if (color[i] == 0) {
                    q.offer(i);
                    color[i] = color[cur] * -1;
                } else if (color[cur] + color[i] != 0) {
                    check = false;
                    return;
                }
            }
        }

    }
}
