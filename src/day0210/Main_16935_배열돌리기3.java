package day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	static int[][] matrix;
	static int N, M;

	public static void main(String[] args) throws IOException {
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

		int[][] result = null;

		int n, m, x, y;
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int menu = 0;
		for (int c = 0; c < R; c++) {
			menu = Integer.parseInt(st2.nextToken());
			switch (menu) {
			case 1:
				result = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[i][j] = matrix[N - 1 - i][j];
					}
				}

				break;
			case 2: // 좌우
				result = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[i][j] = matrix[i][M - 1 - j];
					}
				}
				break;
			case 3: // 90도
				result = new int[M][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[j][N - 1 - i] = matrix[i][j];
					}
				}

				int tmp = N;
				N = M;
				M = tmp;
				break;
			case 4:
				result = new int[M][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						result[M - 1 - j][i] = matrix[i][j];
					}
				}

				tmp = N;
				N = M;
				M = tmp;
				break;
			case 5:
				n = N / 2;
				m = M / 2;
				result = new int[N][M];
				for (int i = 0; i < n; i++) {
					x = n + i;
					y = 0;
					for (int j = 0; j < m; j++) { // 4
						result[i][j] = matrix[x][y++];
					}
					x = i;
					y = 0;
					for (int j = m; j < M; j++) { // 1
						result[i][j] = matrix[x][y++];
					}
				}

				for (int i = n; i < N; i++) {
					x = i;
					y = m;
					for (int j = 0; j < m; j++) { // 3
						result[i][j] = matrix[x][y++];
					}
					x = i - (N / 2);
					y = m;
					for (int j = m; j < M; j++) { // 2
						result[i][j] = matrix[x][y++];
					}
				}

				break;
			case 6:
				n = N / 2;
				m = M / 2;
				result = new int[N][M];
				for (int i = 0; i < n; i++) {
					x = i;
					y = m;
					for (int j = 0; j < m; j++) { // 2
						result[i][j] = matrix[x][y++];
					}
					x = n + i;
					y = m;
					for (int j = m; j < M; j++) { // 3
						result[i][j] = matrix[x][y++];
					}
				}

				for (int i = n; i < N; i++) {
					x = i - (N / 2);
					y = 0;
					for (int j = 0; j < m; j++) { // 1
						result[i][j] = matrix[x][y++];
					}
					x = i;
					y = 0;
					for (int j = m; j < M; j++) { // 4
						result[i][j] = matrix[x][y++];
					}
				}

				break;
			}

			matrix = result;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}

	}
}
