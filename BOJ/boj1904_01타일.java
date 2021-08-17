package BOJ;

import java.util.Scanner;

public class boj1904_01타일 {
	static int[] arr = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;

		int n = sc.nextInt();

		for (int i = 3; i < arr.length; i++) {
			arr[i] = -1;
		}
		System.out.println(Tile(n));
	}

	public static int Tile(int n) {
		if (arr[n] == -1) {
			arr[n] = (Tile(n - 1) + Tile(n - 2)) % 15746;
		}
		return arr[n];
	}
}
