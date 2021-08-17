package SWEA.Problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongTimeAgo2048 {
	static int[][] arr;
	static int N;
	static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			arr = new int[N][N];
			result = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Array_2048(order);

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(result[i][j] + " ");

				}
				System.out.println();
			}

		}
	}

	public static void Array_2048(String order) {
		switch (order) {
			case "up":

				for (int j = 0; j < N; j++) {
					for (int i = 0; i < N - 1; i++) {
						if (arr[i][j] == 0)
							continue;
						int index = i + 1;

						while (arr[index][j] == 0) {
							if (index == N - 1)
								break;
							index++;
						}

						if (arr[index][j] == 0)
							continue;

						if (arr[i][j] == arr[index][j]) {
							arr[i][j] *= 2;
							arr[index][j] = 0;
							i = index;
						}
					}

					int current = 0;
					for (int i = 0; i < N; i++) {
						if (arr[i][j] != 0) {
							result[current++][j] = arr[i][j];
						}
					}
				}
				break;
			case "down":
				for (int j = 0; j < N; j++) {
					for (int i = N - 1; i > 0; i--) {
						if (arr[i][j] == 0)
							continue;
						int index = i - 1;
						while (arr[index][j] == 0) {
							if (index == 0)
								break;
							index--;
						}
						if (arr[index][j] == 0)
							continue;
						if (arr[i][j] == arr[index][j]) {
							arr[i][j] *= 2;
							arr[index][j] = 0;
							i = index;
						}
					}
					int current = N - 1;
					for (int i = N - 1; i >= 0; i--) {
						if (arr[i][j] != 0) {
							result[current--][j] = arr[i][j];
						}
					}
				}
				break;
			case "left":
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N - 1; j++) {
						if (arr[i][j] == 0)
							continue;
						int index = j + 1;

						while (arr[i][index] == 0) {
							if (index == N - 1)
								break;
							index++;
						}
						if (arr[i][index] == 0)
							continue;

						if (arr[i][j] == arr[i][index]) {
							arr[i][j] *= 2;
							arr[i][index] = 0;
							j = index;
						}
					}
					int current = 0;
					for (int j = 0; j < N; j++) {
						if (arr[i][j] != 0) {
							result[i][current++] = arr[i][j];
						}
					}
				}
				break;
			case "right":
				for (int i = 0; i < N; i++) {
					for (int j = N - 1; j > 0; j--) {
						if (arr[i][j] == 0)
							continue;
						int index = j - 1;

						while (arr[i][index] == 0) {
							if (index == 0)
								break;
							index--;
						}
						if (arr[i][index] == 0)
							continue;

						if (arr[i][j] == arr[i][index]) {
							arr[i][j] *= 2;
							arr[i][index] = 0;
							j = index;
						}
					}
					int current = N - 1;
					for (int j = N - 1; j >= 0; j--) {
						if (arr[i][j] != 0) {
							result[i][current--] = arr[i][j];
						}
					}
				}
				break;
		}
	}

}
