package BOJ.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj4386_별자리만들기 {
    static float[][] star;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        star = new float[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            star[i][0] = x;
            star[i][1] = y;
        }
        Arrays.sort(star, new Comparator<float[]>() {

            @Override
            public int compare(float[] o1, float[] o2) {
                if (o1[0] == o2[0]) {
                    return (int) (o1[1] - o2[1]);
                } else {
                    return (int) (o1[0] - o2[0]);
                }
            }

        });

        double minX = star[0][0];
        double minY = star[0][1];
        double maxX = star[N - 1][0];
        double maxY = star[N - 1][1];

        double disX = Math.pow(maxX - minX, 2);
        double disY = Math.pow(maxY - minY, 2);

        double distance = Math.sqrt(disX + disY);

        System.out.printf("%.2f", distance);
    }
}
