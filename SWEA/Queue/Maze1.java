package SWEA.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze1 {
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[16][16];
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}

			int ans = bfs(startX, startY);
			bw.write("#" + tc + " " + ans);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visit = new boolean[16][16];
		visit[x][y] = true;
		q.offer(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair pair = q.poll();

			for (int i = 0; i < 4; i++) {
				int rex = pair.x + dx[i];
				int rey = pair.y + dy[i];

				if (isWall(rex, rey) || visit[rex][rey])
					continue;
				if (map[rex][rey] == 0) {
					visit[rex][rey] = true;
					q.offer(new Pair(rex, rey));
				} else if (map[rex][rey] == 3)
					return 1;

			}
		}
		return 0;
	}

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	public static boolean isWall(int x, int y) {
		if (x < 0 || x >= 16)
			return true;
		if (y < 0 || y >= 16)
			return true;
		return false;
	}
}
