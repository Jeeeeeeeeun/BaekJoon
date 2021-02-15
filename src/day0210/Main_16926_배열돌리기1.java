package day0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	static int[][] matrix;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			rotate();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static void rotate() {
		for (int c = 0; c < Math.min(N, M) / 2; c++) {
			int n = matrix[c][c];
			int x = c;
			int y = c;

			for (int i = c; i < M - 1 - c; i++) {
				matrix[x][y] = matrix[x][++y];
			}
			for (int i = c; i < N - 1 - c; i++) {
				matrix[x][y] = matrix[++x][y];
			}
			for (int i = c; i < M - 1 - c; i++) {
				matrix[x][y] = matrix[x][--y];
			}
			for (int i = c; i < N - 1 - c; i++) {
				matrix[x][y] = matrix[--x][y];
			}
			matrix[c + 1][c] = n;
		}
	}
}
