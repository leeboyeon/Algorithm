package SWEA.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class AloneCharacter {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            for (char c : arr) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("#" + tc + " " + "Good");

            } else {
                String result = "";
                while (!stack.isEmpty()) {
                    result += stack.pop();
                }
                StringBuilder sb = new StringBuilder(new String(result));

                System.out.println("#" + tc + " " + sb.reverse().toString());

            }

        }
    }

}
