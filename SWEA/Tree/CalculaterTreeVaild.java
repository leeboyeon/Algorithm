package SWEA.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CalculaterTreeVaild {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		String item;
		for (int tc = 1; tc <= 10; tc++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String[] str = br.readLine().split(" ");

				if (i < N / 2) {
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						result = 1;
					} else
						result = 0;
				} else {
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						result = 0;
					}
				}
			}
			bw.write("#" + tc + " " + result);
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
