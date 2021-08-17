package SWEA.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Createpwd {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 8; i++) {

				int input = Integer.parseInt(st.nextToken());
				q.offer(input);
			}
			Loop1: while (true) {

				for (int i = 1; i <= 5; i++) {
					int front = q.poll();
					front -= i;
					if (front <= 0)
						front = 0;
					q.offer(front);
					if (front == 0)
						break Loop1;
				}

			}
			bw.write("#" + tc + " ");
			while (!q.isEmpty()) {
				bw.write(q.poll() + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

}
