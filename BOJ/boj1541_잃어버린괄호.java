package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                tmp += Integer.parseInt(st2.nextToken());

            }
            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);

    }
}
