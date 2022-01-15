package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj1038_감소하는수 {
    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        if (N > 1022) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i <= 9; i++) {
            backtrack(i, 1);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    // 1000000000
    static void backtrack(long index, int count) {
        if (count > 10) {
            // 9876543210
            return;
        }

        list.add(index);
        // index == 3
        for (int i = 0; i <= 9; i++) {
            if (index % 10 > i) {
                // 3 > 0 1 2
                // 3 30 31 32 4
                backtrack((index * 10) + i, count + 1);
                // 30 31 32
            }
        }
    }
}
