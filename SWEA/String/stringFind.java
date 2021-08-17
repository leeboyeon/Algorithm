package SWEA.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class stringFind {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			String input = sc.next();
			str = sc.next();
			int count = 0;
			int idx = 0;

			for (int i = 0; i < str.length(); i++) {
				idx = str.indexOf(input);
				if (idx == -1)
					break;
				str = str.substring(idx + input.length(), str.length());
				count++;
			}
			System.out.println("#" + test_case + " " + String.valueOf(count));
		}

	}

}
