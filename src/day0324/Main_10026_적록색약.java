package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10026_적록색약 {

	static int N;
	static char picture[][];
	static boolean[][] visited;
	static int nCnt = 0, rgCnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		picture = new char[N][N];
		visited = new boolean[N][N];

		// 값 입력
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = s.charAt(j);
			}
		}

		// 적록색약X
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					nCnt++;
				}
			}
		}

		// 적록색약
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs2(i, j);
					rgCnt++;
				}
			}
		}

		System.out.println(nCnt + " " + rgCnt);

	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 적록색약X
	private static void dfs(int x, int y) {
		Stack<int[]> stack = new Stack<>();// {x,y}넣은 스택

		stack.push(new int[] { x, y });
		visited[x][y] = true;

		while (!stack.isEmpty()) {
			int[] curr = stack.pop();

			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				// 색이 같고 방문하지 않았으면 스택에 넣고 방문처리
				if (picture[nx][ny] == picture[x][y] && !visited[nx][ny]) {
					stack.push(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}

	}

	// 적록색약
	private static void dfs2(int x, int y) {
		Stack<int[]> stack = new Stack<>();

		stack.push(new int[] { x, y });
		visited[x][y] = true;

		while (!stack.isEmpty()) {
			int[] curr = stack.pop();
			char color = picture[curr[0]][curr[1]];

			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				// RG vs B
				if (color == 'B') {
					if (picture[nx][ny] == picture[x][y] && !visited[nx][ny]) {
						stack.push(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				} else {
					if (picture[nx][ny] != 'B' && !visited[nx][ny]) {
						stack.push(new int[] { nx, ny });
						visited[nx][ny] = true;
					}
				}

			}
		}

	}
}
