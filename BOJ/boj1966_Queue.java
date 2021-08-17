package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966_Queue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			// Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				int printer = Integer.parseInt(st.nextToken());
				q.offer(printer);
			}
			boolean flag = true;
			int count = 1;
			int max = 0;
			while (!q.isEmpty()) {
				if (flag) {
					max = 0;
					for (int i = 0; i < q.size(); i++) {
						if (max < q.peek())
							max = q.peek();
						q.offer(q.peek());
						q.poll();
					}
				}
				if (M == 0 && q.peek() == max) {
					System.out.println(count);
					break;
				} else if (M == 0 && q.peek() != max) {
					M = q.size() - 1;
					q.offer(q.peek());
					q.poll();
					flag = false;
				} else if (q.peek() == max) {
					count++;
					q.poll();
					M--;
					flag = true;
				} else {
					q.offer(q.peek());
					q.poll();
					M--;
					flag = false;
				}
			}

		}
	}

}
