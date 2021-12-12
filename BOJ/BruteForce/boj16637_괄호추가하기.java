package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj16637_괄호추가하기 {
    static ArrayList<Integer> number;
    static ArrayList<Character> op;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        number = new ArrayList<>();
        op = new ArrayList<>();
        result = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                number.add(c - '0');
            } else {
                op.add(c);
            }
        }
        dfs(0, number.get(0));

        System.out.println(result);
    }

    static void dfs(int cnt, int answer) {
        if (cnt == op.size()) {
            result = Math.max(result, answer);
            return;
        }

        int check = calculate(answer, number.get(cnt + 1), op.get(cnt));
        dfs(cnt + 1, check);

        if (cnt + 1 < op.size()) {
            check = calculate(number.get(cnt + 1), number.get(cnt + 2), op.get(cnt + 1));
            int tmp = calculate(answer, check, op.get(cnt));
            dfs(cnt + 2, tmp);
        }
    }

    static int calculate(int curResult, int num, char op) {
        if (op == '+') {
            return curResult + num;
        }
        if (op == '-') {
            return curResult - num;
        }
        if (op == '*') {
            return curResult * num;
        }
        // if (op == '/') {
        // return curResult / num;
        // }
        return 0;
    }
}
