package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int[][] matrix;
	static int N, M;

	// 우하좌상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			rotate(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()),
					Integer.parseInt(st2.nextToken()));
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += matrix[i][j];
			}
			if (min > sum)
				min = sum;
		}

		System.out.println(min);

	}

	public static void rotate(int r, int c, int s) {
		int total_size = 2 * s + 1;

		for (int i = 0; i < total_size / 2; i++) {
			int startX = r - s - 1 + i;
			int startY = c - s - 1 + i;
			int endX = r + s - 1 - i;
			int endY = c + s - 1 - i;
			int size = total_size - (2 * i);

			int x = startX;
			int y = startY;

			int prev = matrix[x][y];
			int n = matrix[x + 1][y];
			for (int j = 0; j < 4; j++) {
				while (true) {
					x += dx[j];
					y += dy[j];

					if (x < startX || y < startY || x > endX || y > endY) {
						x -= dx[j];
						y -= dy[j];
						break;
					}

					int tmp = matrix[x][y];
					matrix[x][y] = prev;
					prev = tmp;

				}
			}
			matrix[startX][startY] = n;
		}
	}
}
