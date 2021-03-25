package day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int startX, startY, startDir;
	static int endX, endY, endDir;

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

		st = new StringTokenizer(br.readLine(), " ");
		startX = Integer.parseInt(st.nextToken()) - 1;
		startY = Integer.parseInt(st.nextToken()) - 1;
		startDir = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		endX = Integer.parseInt(st.nextToken()) - 1;
		endY = Integer.parseInt(st.nextToken()) - 1;
		endDir = Integer.parseInt(st.nextToken());

		bfs();

	}

	// 동서남북
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0, };

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startX, startY, startDir, 0 });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {

			int[] curr = queue.poll();
			System.out.println(Arrays.toString(curr));

			int currX = curr[0];
			int currY = curr[1];
			int currD = curr[2];
			int currCnt = curr[3];

			// 성공
			if (currX == endX && currY == endY && currD == endDir) {
				System.out.println(currCnt);
				break;
			}

			// 방향전환
			for (int i = 0; i < 4; i++) {
				if (i + 1 == currD)
					continue;
				int rotate = 1;

				if (currD == 1) {
					if (i + 1 == 2) {
						rotate = 2;
					}
				} else if (currD == 2) {
					if (i + 1 == 1)
						rotate = 2;
				} else if (currD == 3) {
					if (i + 1 == 4)
						rotate = 2;
				} else if (currD == 4) {
					if (i + 1 == 3)
						rotate = 2;
				}

				queue.offer(new int[] { currX, currY, i + 1, currCnt + rotate });
			}

			// 직진 -> 1,2,3칸
			for (int i = 1; i <= 3; i++) {
				int x = currX + dx[currD - 1] * i;
				int y = currY + dy[currD - 1] * i;

				if (x < 0 || y < 0 || x >= N || y >= M)
					break;

				// 이동 가능
				if (map[x][y] == 0) {
					if (!visited[x][y]) {
						visited[x][y] = true;
						queue.offer(new int[] { x, y, currD, currCnt + 1 });
					}
				}

			}

		}
	}

}
