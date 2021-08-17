package BOJ;

import java.util.Scanner;

public class boj1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		num = sc.nextInt();
		System.out.println(calculate(num, 0));

	}

	public static int calculate(int num, int count) {
		if (num < 2) {
			return count;
		}
		return Math.min(calculate(num / 2, count + 1 + (num % 2)), calculate(num / 3, count + 1 + (num % 3)));
	}
}
