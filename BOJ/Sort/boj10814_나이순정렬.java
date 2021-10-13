package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] crue = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            crue[i][0] = String.valueOf(age);
            crue[i][1] = name;
        }
        Arrays.sort(crue, new Comparator<String[]>() {
            @Override
            public int compare(String[] age1, String[] age2) {
                return Integer.compare(Integer.parseInt(age1[0]), Integer.parseInt(age2[0]));
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(crue[i][0] + " " + crue[i][1]);
        }
    }
}
