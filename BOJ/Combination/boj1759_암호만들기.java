package BOJ.Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759_암호만들기 {
    static char[] arr;
    static boolean[] visit;
    static int L, C;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        visit = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        combination(0, 0, 0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    public static void combination(int start, int count, int consonant, int gather) {
        // consonant : 자음 gather : 모음

        if (count == L) {
            if (gather >= 1 && consonant >= 2) {
                for (int i = 0; i < C; i++) {
                    if (visit[i]) {
                        sb.append(arr[i]);
                    }
                }
                sb.append("\n");
                return;
            }
        }
        for (int i = start; i < C; i++) {
            visit[i] = true;
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                combination(i + 1, count + 1, consonant, gather + 1);
            } else {
                combination(i + 1, count + 1, consonant + 1, gather);
            }
            visit[i] = false;
        }
    }
}
