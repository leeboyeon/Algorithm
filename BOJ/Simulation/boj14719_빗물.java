package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14719_빗물 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 0);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            solution(value);

        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void solution(int value) {

        for (int j = 1; j <= M; j++) {
            for (int i = 0; i < value; i++) {
                map[i][j] = 1;
            }
        }

    }
}
