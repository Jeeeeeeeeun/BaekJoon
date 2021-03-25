package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static class Cheese {
		int x, y, day;

		public Cheese(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

		@Override
		public String toString() {
			return "Cheese [x=" + x + ", y=" + y + ", day=" + day + "]";
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Cheese> queue;
	static int cnt = 0;
	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.println(day);
		System.out.println(cnt);

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
//		Queue<Cheese> qTmp = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
					queue.offer(new Cheese(i, j, -1));
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			Cheese curr = queue.poll();

//			if (curr.day == 0) {
			System.out.println(curr);
//			}

			if (day < curr.day) {
				day = curr.day;
				cnt = 0;
			}

			if (day == curr.day) {
				cnt++;
			}

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;

				if (map[x][y] == 0 && !visited[x][y]) {
					queue.offer(new Cheese(x, y, -1));
					visited[x][y] = true;
				} else if (map[x][y] == 1 && !visited[x][y]) {
					map[x][y] = 0;
					queue.offer(new Cheese(x, y, curr.day + 1));
					visited[x][y] = true;
				}
			}

		}

	}

}