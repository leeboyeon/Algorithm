package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1547_공 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[4];

        // init
        Arrays.fill(map, 0);
        map[1] = 1;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aa = map[a];
            int bb = map[b];

            map[a] = bb;
            map[b] = aa;

        }

        for (int i = 1; i <= 3; i++) {
            if (map[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
