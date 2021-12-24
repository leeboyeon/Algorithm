package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class boj10773_zero {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            sum += cur;
        }

        System.out.println(sum);
    }
}
