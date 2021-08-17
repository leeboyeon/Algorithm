package SWEA.String;

import java.util.Scanner;

public class Palindrome1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		for (int test_case = 1; test_case <= 10; test_case++) {
			int size = sc.nextInt();
			int result = 0;

			for (int i = 0; i < 8; i++) {
				arr[i] = sc.next().toCharArray();
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 9 - size; j++) {
					int count = 0;
					for (int k = 0; k < size / 2; k++) {
						if (arr[i][j + k] != arr[i][j + size - k - 1]) {
							count--;
						}

					}
					if (count == 0) {
						result++;
					}
				}
			}

			for (int i = 0; i < 9 - size; i++) {
				for (int j = 0; j < 8; j++) {
					int count = 0;
					for (int k = 0; k < size / 2; k++) {
						if (arr[i + k][j] != arr[i + size - k - 1][j]) {
							count--;
						}
					}
					if (count == 0) {
						result++;
					}
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}

}
