package SWEA.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	String item;
	int left;
	int right;

	public Node(String item, int left, int right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
}

public class CalculaterTree {
	static Node[] tree;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		String item;
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new Node[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				item = st.nextToken();

				if (st.hasMoreTokens()) {
					tree[index] = new Node(item, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else {
					tree[index] = new Node(item, 0, 0);
				}
			}

			for (int i = N; i > 0; i--) {
				if (tree[i].left != 0) {
					int num1 = Integer.parseInt(tree[tree[i].left].item);
					int num2 = Integer.parseInt(tree[tree[i].right].item);

					switch (tree[i].item) {
						case "+":
							tree[i].item = String.valueOf(num1 + num2);

							break;
						case "-":
							tree[i].item = String.valueOf(num1 - num2);

							break;
						case "/":
							tree[i].item = String.valueOf(num1 / num2);

							break;
						case "*":
							tree[i].item = String.valueOf(num1 * num2);

							break;

					}

				}

			}

			bw.write("#" + tc + " " + tree[1].item);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
