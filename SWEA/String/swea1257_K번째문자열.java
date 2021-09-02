package SWEA.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class swea1257_K번째문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] result = new String[str.length()];

            for (int i = 0; i < str.length(); i++) {
                result[i] = str.substring(i);
            }
            Arrays.sort(result);
            List<String> list = new ArrayList<>();
            Outer: for (int i = 0; i < result.length; i++) {
                for (int j = 1; j <= result[i].length(); j++) {
                    String tmp = result[i].substring(0, j);
                    if (!list.contains(tmp)) {
                        list.add(tmp);
                    }
                    if (list.size() == K) {
                        break Outer;
                    }

                }
            }

            if (K <= list.size()) {
                System.out.println("#" + tc + " " + list.get(K - 1).toString());
            } else {
                System.out.println("#" + tc + " none");
            }
        }
    }
}
