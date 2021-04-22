package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
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
	static boolean[][] visited;
	static int islandCnt = 1;
	static int[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j); // 섬 구분
					islandCnt++;
				}
			}
		}
		islandCnt--;

		adjMatrix = new int[islandCnt][islandCnt];
		for (int i = 0; i < islandCnt; i++) {
			Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bfs2(i, j);
				}
			}
		}

		// 최소신장트리 - prim
		int[] minEdge = new int[islandCnt];
		boolean[] visited = new boolean[islandCnt];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0; // 시작정점
		int result = 0;

		for (int c = 0; c < islandCnt; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 0; i < islandCnt; i++) {
				if (!visited[i] && min > minEdge[i]) { // 가장 작은 요소 뽑기
					min = minEdge[i];
					minVertex = i;
				}
			}

			if (min != Integer.MAX_VALUE) {
				// 정점 방문
				result += min;
				visited[minVertex] = true;

				// minEdge update
				for (int i = 0; i < visited.length; i++) {
					if (!visited[i] && adjMatrix[minVertex][i] != Integer.MAX_VALUE
							&& minEdge[i] > adjMatrix[minVertex][i]) {
						minEdge[i] = adjMatrix[minVertex][i]; // 값 갱신
					}
				}
			} else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(result);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 거리 구하기
	private static void bfs2(int x, int y) {

		int start = map[x][y] - 1; // 다리 시작지점

		// 방향별로
		for (int i = 0; i < 4; i++) {
			boolean[][] visited = new boolean[N][M];
			Queue<Loc> queue = new LinkedList<>();
			queue.offer(new Loc(x, y, 0));
			visited[x][y] = true;

			while (!queue.isEmpty()) {
				Loc curr = queue.poll();

				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					break;

				if (map[nx][ny] == 0) {
					queue.add(new Loc(nx, ny, curr.len + 1));
					visited[nx][ny] = true;
				} else { // 섬만난경우
					int end = map[nx][ny] - 1; // 만난 섬
					if (start == end)
						break;
					if (adjMatrix[start][end] > curr.len && curr.len >= 2) {
						adjMatrix[start][end] = curr.len;
						adjMatrix[end][start] = curr.len;
					}
					break;
				}
			}
		}
	}

	// 섬 개수 구하기
	private static void bfs(int x, int y) {
		Queue<Loc> queue = new LinkedList<>();
		queue.offer(new Loc(x, y, 0));
		visited[x][y] = true;
		map[x][y] = islandCnt;

		int lx = 0, ly = 0;
		while (!queue.isEmpty()) {
			Loc curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new Loc(nx, ny, 0));
					map[nx][ny] = islandCnt;
					lx = nx;
					ly = ny;
				}
			}

		}

	}

}
