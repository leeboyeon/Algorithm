package BOJ.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1021_회전하는큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> q = new ArrayList<>();
        int[] idx = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            idx[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }

        int check = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                if (q.get(i) == idx[j]) {

                }
                check++;
            }
        }

    }
}
