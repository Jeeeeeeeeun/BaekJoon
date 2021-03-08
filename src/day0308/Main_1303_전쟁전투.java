package day0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {
	static int N, M;
	static char[][] field;
	static boolean[][] visited;
	static int wCnt = 0, bCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			field[i] = s.toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;

				bfs(i, j);
			}
		}

		System.out.println(wCnt + " " + bCnt);
	}

	// 상 우 하 좌
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		int cnt = 1;
		while (queue.size() != 0) {
			int[] q = queue.poll();
			int currX = q[0];
			int currY = q[1];

			for (int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;

				if (!visited[nx][ny] && field[nx][ny] == field[currX][currY]) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					cnt++;
				}

			}
		}

		if (field[x][y] == 'W')
			wCnt += Math.pow(cnt, 2);
		else if (field[x][y] == 'B')
			bCnt += Math.pow(cnt, 2);
	}

}
