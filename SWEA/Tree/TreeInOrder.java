package SWEA.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TreeInOrder {
	static int N;
	static char[] tree;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tree[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}

			bw.write("#" + tc + " ");
			inOrder(1);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static void inOrder(int index) throws IOException {
		if (index > N) {
			return;
		}
		inOrder(index * 2);
		bw.write(tree[index]);
		inOrder(index * 2 + 1);
	}
}
