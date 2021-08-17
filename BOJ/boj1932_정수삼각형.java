package BOJ;

import java.util.Scanner;

public class boj1932_정수삼각형 {
	public static int[][] arr;
	public static int[][] visit;
	public static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		visit = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			visit[n - 1][i] = arr[n - 1][i];
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int dp, int idx) {
		if (dp == n - 1)
			return visit[dp][idx];

		if (visit[dp][idx] == 0) {
			visit[dp][idx] = Math.max(dfs(dp + 1, idx), dfs(dp + 1, idx + 1)) + arr[dp][idx];
		}
		return visit[dp][idx];
	}
}
