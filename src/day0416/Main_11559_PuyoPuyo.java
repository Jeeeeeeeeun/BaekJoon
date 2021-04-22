package day0416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11559_PuyoPuyo {
	static char map[][] = new char[12][6];
	static List<int[]> pop = new ArrayList<>();
	static int combo = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		while (true) {
			pop.clear();

			// 터뜨리기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						bfs(i, j);
					}
				}
			}

			// 터뜨릴 게 없으면 끝
			if (pop.size() == 0) {
				break;
			}

			// pop 맵에서 지우기
			for (int i = 0; i < pop.size(); i++) {
				int[] curr = pop.get(i);
				map[curr[0]][curr[1]] = '.';
			}

			// 내리기
			for (int i = 0; i < 6; i++) {
				for (int j = 11; j >= 0; j--) {
					if (map[j][i] == '.') {
						for (int k = j - 1; k >= 0; k--) {
							if (map[k][i] != '.') {
								map[j][i] = map[k][i];
								map[k][i] = '.';
								break;
							}
						}
					}
				}
			}

			// 연쇄처리
			combo++;
		}

		System.out.println(combo);
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static boolean bfs(int x, int y) {

		boolean[][] visited = new boolean[12][6];
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });
		visited[x][y] = true;
		pop.add(new int[] { x, y });
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
					continue;

				if (map[nx][ny] != '.' && !visited[nx][ny] && map[x][y] == map[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
					pop.add(new int[] { nx, ny });
					cnt++;
				}
			}
		}

		if (cnt < 4) {
			for (int i = 0; i < cnt; i++) {
				pop.remove(pop.size() - 1);
			}
			return false;
		} else {
			return true;
		}
	}
}
