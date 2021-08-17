package BOJ;

import java.util.Scanner;

public class boj1546_평균 {

	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int total = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			int score = sc.nextInt();
			total += score;
			if (score > max) {
				max = score;
			}
		}
		double avg = 0;
		avg = 100.0 * total / max / N;
		System.out.println(avg);
	}

}
