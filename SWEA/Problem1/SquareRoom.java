package SWEA.Problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareRoom {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] visit;
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0) {
						dfs(i, j);
					}
					if (max < visit[i][j]) {
						max = visit[i][j];
						min = arr[i][j];
					} else if (max == visit[i][j]) {
						if (min > arr[i][j])
							min = arr[i][j];
						else
							min = min;
					}
				}
			}
			System.out.println("#" + tc + " " + min + " " + max);

		}
	}

	public static void dfs(int y, int x) {
		visit[y][x] = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (isWall(ny, nx))
				continue;
			if (arr[ny][nx] == arr[y][x] + 1) {
				if (visit[ny][nx] == 0)
					dfs(ny, nx);
				if (visit[y][x] < 1 + visit[ny][nx]) {
					visit[y][x] = 1 + visit[ny][nx];
				}
			}
		}
	}

	public static boolean isWall(int x, int y) {
		if (x < 0 || x >= N)
			return true;
		if (y < 0 || y >= N)
			return true;
		return false;
	}
}
