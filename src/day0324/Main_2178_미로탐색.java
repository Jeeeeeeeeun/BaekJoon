package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
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
			return "Loc [x=" + x + ", y=" + y + ", len=" + len + "]";
		}

	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		Queue<Loc> queue = new LinkedList<>();
		queue.offer(new Loc(0, 0, 1));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Loc curr = queue.poll();

			if (curr.x == N - 1 && curr.y == M - 1) {
				System.out.println(curr.len);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;

				if (map[x][y] == 1 && !visited[x][y]) {
					queue.offer(new Loc(x, y, curr.len + 1));
					visited[x][y] = true;
				}

			}

		}

	}
}
