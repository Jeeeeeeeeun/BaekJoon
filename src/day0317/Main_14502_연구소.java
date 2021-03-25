package day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "blank [x=" + x + ", y=" + y + "]";
		}
	}

	static int N, M;
	static int[][] map;
	static ArrayList<Location> blanks;
	static ArrayList<Location> virus;
	static Location[] choose;
	static int maxSafeArea = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		blanks = new ArrayList<>();
		virus = new ArrayList<>();
		choose = new Location[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					blanks.add(new Location(i, j));
				} else if (map[i][j] == 2) {
					virus.add(new Location(i, j));
				}
			}
		}

		makeWall(0, 0);

		System.out.println(maxSafeArea);
	}

	private static void makeWall(int cnt, int curr) {
		if (cnt >= 3) {
			// 벽 생성
			for (int i = 0; i < 3; i++) {
				int x = choose[i].x;
				int y = choose[i].y;

				map[x][y] = 1;
			}

			// virus 전염
			int virusCnt = bfs();
			int safe = blanks.size() + virus.size() - 3 - virusCnt;

			if (maxSafeArea < safe) {
				maxSafeArea = safe;
			}

			// 벽 되돌리기
			for (int i = 0; i < 3; i++) {
				int x = choose[i].x;
				int y = choose[i].y;

				map[x][y] = 0;
			}
			return;
		}

		for (int i = curr; i < blanks.size(); i++) {
			choose[cnt] = blanks.get(i);
			makeWall(cnt + 1, i + 1);
		}

	}

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs() {
		boolean[][] visited = new boolean[N][M];
		int virusCnt = 0;

		Queue<Location> queue = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			virusCnt++;
			queue.offer(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y] = true;
		}

		while (!queue.isEmpty()) {
			Location v = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = v.x + dx[i];
				int y = v.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;

				if (map[x][y] == 0 && !visited[x][y]) {
					virusCnt++;
					queue.offer(new Location(x, y));
					visited[x][y] = true;
				}
			}
		}
		return virusCnt;
	}

}
