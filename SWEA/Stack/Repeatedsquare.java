package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Repeatedsquare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			Stack<Integer> stack = new Stack<>();
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			for (int i = 0; i < size; i++) {
				stack.push(num);
			}

			int result = 1;

			for (int i = 0; i < size; i++) {
				int numf = stack.pop();
				result *= numf;
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(result));
			bw.newLine();
			bw.flush();
		}
	}

}
