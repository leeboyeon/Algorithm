package SWEA.Greedy;

import java.util.Scanner;

public class testMaxprize {
	static int result;
	static int maxCount;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String number = sc.next();
			maxCount = sc.nextInt();
			check = new boolean[maxCount + 1][1000000];
			result = 0;
			changeNumber(number.toCharArray(), 0);
			System.out.println("#" + t + " " + result);
		}
	}

	public static void changeNumber(char[] numberChar, int nowCount) {
		if (maxCount == nowCount) {
			result = result > getInteger(numberChar) ? result : getInteger(numberChar);
			return;
		}
		int max = numberChar.length;
		for (int i = 0; i < max - 1; i++) {
			for (int j = i + 1; j < max; j++) {
				char[] tempNumber = swap(numberChar, i, j);
				if (!check[nowCount + 1][getInteger(tempNumber)]) {
					check[nowCount + 1][getInteger(tempNumber)] = true;
					changeNumber(tempNumber, nowCount + 1);
				}
			}
		}
	}

	public static int getInteger(char[] numberChar) {
		return Integer.valueOf(String.valueOf(numberChar));
	}

	public static char[] swap(char[] numberChar, int point1, int point2) {
		char[] tempNumber = numberChar.clone();
		char num = tempNumber[point1];
		tempNumber[point1] = tempNumber[point2];
		tempNumber[point2] = num;
		return tempNumber;
	}
}
