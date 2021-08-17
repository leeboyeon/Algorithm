package SWEA.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
	static boolean[][] distance;
	static int max = Integer.MIN_VALUE;
	static int startpoint;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			int datasize = Integer.parseInt(st.nextToken());
			startpoint = Integer.parseInt(st.nextToken());

			distance = new boolean[101][101];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < datasize / 2; i++) {

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				distance[from][to] = true;

			}
			int ans = bfs();
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	static int bfs() {
		int ans = 0;
		boolean[] visit = new boolean[101];
		int size = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(startpoint);
		visit[startpoint] = true;
		while (!q.isEmpty()) {
			size = q.size();
			max = 0;
			while (--size >= 0) {
				int cur = q.poll();
				for (int i = 1; i <= 100; i++) {
					if (distance[cur][i] && !visit[i]) {
						q.offer(i);
						if (max < i)
							max = i;
						visit[i] = true;
					}
				}
			}
			if (max > 0) {
				ans = max;
			}
		}
		return ans;
	}
}
