package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj7568_덩치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][3];
        int[] ranking = new int[N];
        int k = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int kg = Integer.parseInt(st.nextToken());
            int cm = Integer.parseInt(st.nextToken());

            people[i][0] = kg;
            people[i][1] = cm;

        }
        int rank = 0;
        for (int i = 0; i < N; i++) {
            rank = 0;
            for (int j = 0; j < N; j++) {
                if (people[i][0] < people[j][0]) {
                    if (people[i][1] < people[j][1]) {
                        rank++;
                    }
                }
            }
            people[i][2] = rank + 1;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(people[i][2] + " ");
        }
    }

}
