package SWEA.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecureCode {
	static int[][] code = { { 0, 0, 0, 1, 1, 0, 1 }, // 0
			{ 0, 0, 1, 1, 0, 0, 1 }, // 1
			{ 0, 0, 1, 0, 0, 1, 1 }, // 2
			{ 0, 1, 1, 1, 1, 0, 1 }, // 3
			{ 0, 1, 0, 0, 0, 1, 1 }, // 4
			{ 0, 1, 1, 0, 0, 0, 1 }, // 5
			{ 0, 1, 0, 1, 1, 1, 1 }, // 6
			{ 0, 1, 1, 1, 0, 1, 1 }, // 7
			{ 0, 1, 1, 0, 1, 1, 1 }, // 8
			{ 0, 0, 0, 1, 0, 1, 1 } // 9
	};
	static int N = 0;
	static int M = 0;
	static int[][] arr = new int[50][100];
	static int[] codeBit = new int[56];
	static int[] codeNum = new int[8];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			boolean Find = false;
			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (arr[i][j] == 1) {
						Find = true;
						for (int k = 0; k < 56; k++) {
							codeBit[k] = arr[i][j - 55 + k];
						}

					}
					if (Find)
						break;
				}
			}
			for (int k = 0; k < 8; k++) {
				for (int i = 0; i < 10; i++) {
					boolean check = true;
					for (int j = 0; j < 7; j++) {
						if (codeBit[(k * 7) + j] != code[i][j]) {
							check = false;
							break;
						}
					}
					if (check) {
						codeNum[k] = i;
						break;
					}
				}
			}

			int checkcode = (codeNum[0] + codeNum[2] + codeNum[4] + codeNum[6]) * 3
					+ (codeNum[1] + codeNum[3] + codeNum[5] + codeNum[7]);

			if (checkcode % 10 == 0) {
				for (int i = 0; i < 8; i++) {
					result += codeNum[i];
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
