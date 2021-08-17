package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindStreet {
	public static boolean[] visited;
	public static int N, idx, value, flag;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[100][100];
			visited = new boolean[100];
			flag = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				idx = Integer.parseInt(st.nextToken());
				value = Integer.parseInt(st.nextToken());
				map[value][idx] = 1;
			}

			dfs(99);
			if (flag == 1) {
				bw.write("#" + tc + " " + flag);
			} else {
				bw.write("#" + tc + " " + flag);
			}
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();

		stack.add(start);
		for (int i = 99; i >= 0; i--) {
			if (map[start][i] == 1) {
				map[start][i] = 0;
				if (i == 0) {
					flag = 1;
					return;
				} else
					dfs(i);
			}
		}
	}

}
