package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504_괄호의값 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int multi = 1;
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
				case '(':
					stack.push(str.charAt(i));
					multi *= 2;
					break;
				case '[':
					stack.push(str.charAt(i));
					multi *= 3;
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						result = 0;
						break;
					}
					if (str.charAt(i - 1) == '(') {
						result += multi;
					}
					stack.pop();
					multi /= 2;
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						result = 0;
						break;
					} else if (str.charAt(i - 1) == '[') {
						result += multi;
					}
					stack.pop();
					multi /= 3;
					break;
			}
		}
		if (!stack.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(result);
		}

	}
}
