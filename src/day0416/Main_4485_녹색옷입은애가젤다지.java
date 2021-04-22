package day0416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	static int N, map[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) // 0 입력시 종료
				break;

			// 맵 입력
			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			int min = dfs(); //시간초과
			int min = djikstra();
			System.out.println("Problem " + tc++ + ": " + min);
		}

	}

	// 다익스트라
	private static int djikstra() {
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N]; // 각 정점까지의 거리
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE); // 무한으로 초기화
		}

		dist[0][0] = map[0][0]; // 0,0 시작정점

		while (true) {
			// 최소값 뽑기
			int minX = -1;
			int minY = -1;
			int cost = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && dist[i][j] < cost) {
						minX = i;
						minY = j;
						cost = dist[i][j];
					}
				}
			}

			// 방문
			visited[minX][minY] = true;

			if (minX == N - 1 && minY == N - 1) { // 방문지점=도착지점이면 끝
				return cost;
			}

			// 4방탐색으로 dist 갱신
			for (int i = 0; i < 4; i++) {
				int nx = minX + dx[i];
				int ny = minY + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (!visited[nx][ny] && dist[nx][ny] > cost + map[nx][ny]) {
					dist[nx][ny] = cost + map[nx][ny];
				}

			}

		}

	}

	static class Loc {
		int x, y, length;

		public Loc(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}

	private static int dfs() {
		Stack<Loc> stack = new Stack<>();
		int[][] memo = new int[N][N];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}

		stack.push(new Loc(0, 0, map[0][0]));
		memo[0][0] = map[0][0];

		while (!stack.isEmpty()) {
			Loc curr = stack.pop();

			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (memo[nx][ny] == -1 || memo[nx][ny] > curr.length + map[nx][ny]) {
					stack.push(new Loc(nx, ny, curr.length + map[nx][ny]));
					memo[nx][ny] = curr.length + map[nx][ny];
				}
			}
		}

		return memo[N - 1][N - 1];
	}
}
