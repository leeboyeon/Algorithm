package BOJ.FloydWashar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj9205_맥주마시면서걸억가기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int store = Integer.parseInt(br.readLine());
            int beer = 20;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int c = 0; c < store + 2; c++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
            }

            boolean[][] visit = new boolean[store + 2][store + 2];
            for (int i = 0; i < store + 2; i++) {
                for (int j = 0; j < store + 2; j++) {
                    ArrayList<Integer> cur = list.get(i);
                    ArrayList<Integer> next = list.get(j);

                    int distance = Math.abs(cur.get(0) - next.get(0)) + Math.abs(cur.get(1) - next.get(1));
                    if (distance <= 1000)
                        visit[i][j] = true;
                }
            }
            for (int k = 0; k < store + 2; k++) {
                for (int i = 0; i < store + 2; i++) {
                    for (int j = 0; j < store + 2; j++) {
                        if (visit[i][k] && visit[k][j]) {
                            visit[i][j] = true;
                        }
                    }
                }
            }
            if (visit[0][store + 1]) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }

    }
}
