package SWEA.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BlancePoint {
	static int[] point;
	static int[] weight;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			point = new int[N];
			weight = new int[N];
			for (int i = 0; i < N; i++) {
				point[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				weight[i] = sc.nextInt();
			}
			System.out.print("#" + tc + " ");

			for (int i = 1; i < N; i++) {
				double sum = 0;
				double left = point[i - 1];
				double right = point[i];
				double mid = (left + right) / 2.0;
				int count = 1;
				do {
					mid = (left + right) / 2.0;
					sum = 0;
					for (int j = 0; j < i; j++) {
						sum += (weight[j]) / ((mid - point[j]) * (mid - point[j]));
					}
					for (int j = i; j < N; j++) {
						sum -= weight[j] / ((point[j] - mid) * (point[j] - mid));
					}
					if (sum == 0)
						break;
					if (sum > 0) {
						left = mid;
					} else {
						right = mid;
					}
					if (sum < 0)
						sum *= (-1);
					if (++count > 50)
						break;
				} while (true);
				System.out.printf("%.10f ", mid);
			}
			System.out.println();
		}

	}

}
