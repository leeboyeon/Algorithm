package SWEA.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1859_백만장자프로젝트 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[] price = new int[size];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < size; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			int buy = 0;
			int result = 0;
			for (int i = price.length - 1; i >= 0; i--) {

				if (price[i] < max) {
					buy += max - price[i];
					result += buy;
				} else if (price[i] >= max) {
					max = price[i];
				}

			}
			System.out.println("#" + tc + " " + result);
		}

	}

}
