package SWEA.Problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrigSquareRoom {
	static int T, N, index, result;
	static int[][] arr;
	static boolean[][] visited;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int count = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];

			index = 0;
			result = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {

					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1, arr[i][j]);
				}
			}
			bw.write("#" + tc + " " + index + " " + result);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y, int count, int start) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isWall(nx, ny))
				continue;
			if (!visited[nx][ny] && arr[nx][ny] == arr[x][y] + 1) {
				dfs(nx, ny, count + 1, start);
			}

			if (count > result) {
				result = count;
				index = start;
			}
			if (count == result) {
				index = Math.min(index, start);
			}
		}
		visited[x][y] = false;
	}

	public static boolean isWall(int x, int y) {
		if (x < 0 || x > N - 1)
			return true;
		if (y < 0 || y > N - 1)
			return true;
		return false;
	}
}
