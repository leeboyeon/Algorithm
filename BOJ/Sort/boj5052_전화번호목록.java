package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj5052_전화번호목록 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int size = Integer.parseInt(br.readLine());

            int min_size = Integer.MAX_VALUE;
            String[] input = new String[size];
            for (int i = 0; i < size; i++) {
                input[i] = br.readLine();
            }
            Arrays.sort(input);

            boolean flag = false;
            for (int i = 0; i < size - 1; i++) {
                if (input[i + 1].startsWith(input[i])) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
/**
 * startsWith : 비교대상 문자열.startsWith("체크할문자열")
 * --> 비교할 문자열이 체크할문자열의 값으로 시작되는지 확인하는 코드
 */
