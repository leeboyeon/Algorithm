package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class WorkSequence {
	public static boolean[] visited;
	public static int E, start, end;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			map = new int[100][100];
			visited = new boolean[100];

			st = new StringTokenizer(br.readLine(), " ");

			dfs(1);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void dfs(int v) {
		Stack<Integer> stack = new Stack<>();

	}

}
