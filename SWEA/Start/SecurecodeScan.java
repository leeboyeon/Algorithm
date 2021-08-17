package SWEA.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SecurecodeScan {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		char[][] temp;
		String input = "";
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.equals(input) || i == 0) {
					input = str;
					continue;
				}
				map[i][j] = str.charAt(j);
			}
		}
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					num = i;
					map = new char[i - num][j];
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println(num);
	}

}