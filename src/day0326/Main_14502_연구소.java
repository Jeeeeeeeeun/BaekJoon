package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}

	}

	static int N, M;
	static int[][] map;
	static ArrayList<Loc> empty = new ArrayList<>();
	static ArrayList<Loc> virus = new ArrayList<>();
	static Loc[] selected = new Loc[3];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					empty.add(new Loc(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Loc(i, j));
				}
			}
		}

		makeWall(0, 0);

		System.out.println(max);

	}

	private static void makeWall(int start, int cnt) {
		if (cnt == 3) {

			// 벽 설치
			for (int i = 0; i < 3; i++) {
				map[selected[i].x][selected[i].y] = 1;
			}

			int newVirusCnt = bfs();
			int safeArea = empty.size() - newVirusCnt - 3; // 0에서 바이러스, 벽세운 공간 제외 = 안전영역

			if (safeArea > max) {
				max = safeArea;
			}

			// 되돌리기
			for (int i = 0; i < 3; i++) {
				map[selected[i].x][selected[i].y] = 0;
			}
			return;
		}

		for (int i = start; i < empty.size(); i++) {
			selected[cnt] = empty.get(i);
			makeWall(i + 1, cnt + 1);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		Queue<Loc> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}

		int virusCnt = 0;
		while (!queue.isEmpty()) {
			Loc v = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = v.x + dx[i];
				int y = v.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= M) {
					continue;
				}

				if (map[x][y] == 0 && !visited[x][y]) {
					queue.offer(new Loc(x, y));
					visited[x][y] = true;
					virusCnt++;
				}
			}
		}

		return virusCnt;
	}

}
