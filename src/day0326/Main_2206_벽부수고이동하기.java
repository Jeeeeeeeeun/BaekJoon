package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간초과
public class Main_2206_벽부수고이동하기 {
	static class Loc {
		int x, y, len;

		public Loc(int x, int y, int len) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}
	}

	static int N, M;
	static int[][] map;
	static ArrayList<Loc> walls = new ArrayList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';

				if (map[i][j] == 1) {
					walls.add(new Loc(i, j, 0));
				}
			}
		}

		for (int i = 0; i < walls.size(); i++) {
			Loc wall = walls.get(i);
			// 벽 없애기
			map[wall.x][wall.y] = 0;

			int n = bfs();

			if (n < min) {
				min = n;
			}

			// 벽 되돌리기
			map[wall.x][wall.y] = 1;
		}

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}

		System.out.println(min);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		int cnt = 0;
		Queue<Loc> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(new Loc(0, 0, 1)); // 시작점
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Loc curr = queue.poll();

			// 도착점 도착
			if (curr.x == N - 1 && curr.y == M - 1) {
				return curr.len;
			}

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				int l = curr.len;

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;

				if (map[x][y] == 0 && !visited[x][y]) {
					queue.offer(new Loc(x, y, l + 1));
					visited[x][y] = true;
				}
			}
		}

		// 도착 X
		return Integer.MAX_VALUE;
	}
}
