package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class boj11581_구호물자 {
    static int[] check;
    static int[][] list;
    static int N;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        list = new int[101][101];
        check = new int[101];
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++) {

                int y = Integer.parseInt(st.nextToken());
                list[i][y] = 1;
            }
        }

        dfs(1);
        System.out.println("NO CYCLE");

    }

    public static void dfs(int v) {
        check[v] = 1;
        for (int i = 1; i < N; i++) {
            if (list[v][i] == 1) {
                System.out.println("CYCLE");
                System.exit(0);
            } else if (check[i] == 0) {
                dfs(i);
            }
        }
        check[v] = -1;
    }
}