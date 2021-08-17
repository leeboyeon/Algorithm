package SWEA.Problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MakeTrackingCourse {
	static int K, N, result, max;
	static int[][] arr;
	static int[][] high;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N][N];
			int maxheight = 0;
			result = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxheight = Math.max(maxheight, arr[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == maxheight) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}

			bw.write("#" + tc + " " + result);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int x, int y, int count, boolean isCut) {

		result = Math.max(result, count);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isWall(nx, ny) || visited[nx][ny])
				continue;
			if (arr[nx][ny] < arr[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, count + 1, isCut);
				visited[nx][ny] = false;
			} else {
				if (!isCut) {
					for (int j = 1; j <= K; j++) {
						isCut = true;
						arr[nx][ny] -= j;
						if (arr[x][y] > arr[nx][ny]) {
							visited[nx][ny] = true;
							dfs(nx, ny, count + 1, isCut);
							visited[nx][ny] = false;
						}
						arr[nx][ny] += j;
						isCut = false;
					}
				}
			}
		}
		visited[x][y] = false;
	}

	public static boolean isWall(int x, int y) {
		if (x < 0 || x >= N)
			return true;
		if (y < 0 || y >= N)
			return true;
		return false;
	}

}
