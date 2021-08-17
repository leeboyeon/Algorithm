package SWEA.String;

import java.util.Scanner;

public class Palindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			char[][] arr = new char[100][100];
			int result = 0;

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.next().toCharArray();
			}
			for (int size = 100; size > 1; size--) {
				if (result > 1)
					break;
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length + 1 - size; j++) {
						int count = 0;
						for (int k = 0; k < size / 2; k++) {
							if (arr[i][j + k] != arr[i][j + size - k - 1]) {
								count--;
							}

						}
						if (count == 0) {
							result = size;
						}
					}
				}

				for (int i = 0; i < arr.length + 1 - size; i++) {
					for (int j = 0; j < arr.length; j++) {
						int count = 0;
						for (int k = 0; k < size / 2; k++) {
							if (arr[i + k][j] != arr[i + size - k - 1][j]) {
								count--;
							}
						}
						if (count == 0) {
							result = size;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);

		}
	}

}
