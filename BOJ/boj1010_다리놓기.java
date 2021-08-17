package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1010_다리놓기 {
	static int[][] bridge = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(combination(M, N)).append('\n');

		}
		System.out.println(sb);
	}

	static int combination(int n, int r) {
		if (bridge[n][r] > 0)
			return bridge[n][r];
		if (n == r || r == 0)
			return bridge[n][r] = 1;

		return bridge[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}
