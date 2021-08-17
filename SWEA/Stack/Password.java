package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Password {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {

			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());

			int size = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();

			for (int i = 0; i < size; i++) {

				if (stack.isEmpty())
					stack.push(arr[i]);
				else {
					if (stack.peek() == arr[i])
						stack.pop();
					else
						stack.push(arr[i]);
				}

			}
			for (char c : stack) {
				sb.append(c);
			}
			System.out.println("#" + tc + " " + sb);

		}

	}

}
