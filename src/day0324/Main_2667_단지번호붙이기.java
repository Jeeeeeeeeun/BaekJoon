package day0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> house = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}

			}
		}

		System.out.println(house.size());

		Collections.sort(house);

		for (int n : house) {
			System.out.println(n);
		}
	}

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;

		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		cnt++;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					cnt++;
				}

			}
		}

		house.add(cnt);
	}
}
