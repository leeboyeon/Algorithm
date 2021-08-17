package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class PairBracket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();
			int T = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] left = { '(', '{', '[', '<' };
			char[] right = { ')', '}', ']', '>' };

			for (int i = 0; i < T; i++) {
				for (int j = 0; j < 4; j++) {
					if (str.charAt(i) == left[j]) {
						stack.push(str.charAt(i));
						break;
					}
					if (str.charAt(i) == right[j]) {
						if (stack.peek() == left[j]) {
							stack.pop();
							break;
						} else {
							stack.push(str.charAt(i));
						}
						break;
					}
				}
			}
			if (stack.isEmpty()) {
				bw.write("#" + tc + " " + "1");
			} else
				bw.write("#" + tc + " " + "0");
			bw.newLine();
			bw.flush();

		}
	}

}
