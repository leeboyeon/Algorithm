package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4311_오래된스마트폰 {
    static int N, O, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] number = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                number[i] = Integer.parseInt(st.nextToken());
            }
            char[] op = new char[O];
            for (int i = 0; i < O; i++) {
                int operation = Integer.parseInt(st.nextToken());
                op[i] = changeOp(operation);
            }
            int w = Integer.parseInt(br.readLine());

            int touch = 1; // '='touch default

        }
    }

    public static char changeOp(int op) {
        if (op == 1) {
            return '+';
        }
        if (op == 2) {
            return '-';
        }
        if (op == 3) {
            return '*';
        }
        if (op == 4) {
            return '/';
        }
        return '=';
    }
}
