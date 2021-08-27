package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] bat = new int[6][2];
        int[] direct = { 1, 2, 3, 4 };
        // input
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            bat[i][0] = dir;
            bat[i][1] = size;
        }

        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;

        for (int i = 0; i < 6; i++) {
            if (bat[i][0] == 1) {
                if (bat[i][1] > max1) {
                    max1 = bat[i][1];
                }
            } else if (bat[i][0] == 2) {
                if (bat[i][1] > max2) {
                    max2 = bat[i][1];
                }
            } else if (bat[i][0] == 3) {
                if (bat[i][1] > max3) {
                    max3 = bat[i][1];
                }
            } else if (bat[i][0] == 4) {
                if (bat[i][1] > max4) {
                    max4 = bat[i][1];
                }
            }
        }
        int xMax = 0;
        int xMin = 0;
        int yMax = 0;
        int yMin = 0;
        xMax = Math.max(max1, max2);
        xMin = Math.abs(max1 - max2);
        yMax = Math.max(max3, max4);
        yMin = Math.abs(max3 - max4);

        int maxSize = xMax * yMax;
        int minSize = xMin * yMin;
        int result = (maxSize - minSize) * K;
        System.out.println(result);

    }

}
