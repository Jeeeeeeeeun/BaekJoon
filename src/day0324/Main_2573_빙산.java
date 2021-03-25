package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int yCnt = 1;

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
			}
		}

		while (true) {
			if (isMelted()) {
				System.out.println(0);
				break;
			}

			int[][] tmp = new int[N][M];

			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, M);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						int n = cntSurround(i, j);
						tmp[i][j] = Math.max(tmp[i][j] - n, 0);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				System.arraycopy(tmp[i], 0, map[i], 0, M);
			}


			int iceCnt = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						dfs(i, j);
						iceCnt++;
					}
				}
			}

			if (iceCnt >= 2) {
				System.out.println(yCnt);
				break;
			} else {
				yCnt++;
			}

		}

	}

	private static boolean isMelted() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(int x, int y) {
		Stack<int[]> st = new Stack<>();

		st.push(new int[] { x, y });
		visited[x][y] = true;

		while (!st.isEmpty()) {
			int[] curr = st.pop();

			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (map[nx][ny] != 0 && !visited[nx][ny]) {
					st.push(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}

	}

	private static int cntSurround(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (map[nx][ny] == 0)
				cnt++;
		}
		return cnt;
	}
}

/*

5 7
0 0 0 0 0 0 0
0 2 9 9 9 0 0
0 3 9 9 9 9 0
0 7 9 9 9 0 0
0 0 0 0 0 0 0

 */
