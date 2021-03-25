package day0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int T = 1; T <= testCase; T++) {

			int n = Integer.parseInt(br.readLine()); // 편의점 개수
			int[][] adjMatrix = new int[n + 2][n + 2];
			int[] locX = new int[n + 2];
			int[] locY = new int[n + 2];

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				locX[i] = Integer.parseInt(st.nextToken());
				locY[i] = Integer.parseInt(st.nextToken());
			}

			// 인접행렬
			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					int dist = Math.abs(locX[i] - locX[j]) + Math.abs(locY[i] - locY[j]);
					adjMatrix[i][j] = adjMatrix[j][i] = dist;
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < locY.length; j++) {
						if (j == i || j == k)
							continue;

						if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}

						if (adjMatrix[i][j] <= 1000) {
							adjMatrix[i][j] = 0;
						}
					}
				}
			}

			if (adjMatrix[0][n + 1] <= 1000)
				System.out.println("happy");
			else {
				System.out.println("sad");
			}

		}

	}
}