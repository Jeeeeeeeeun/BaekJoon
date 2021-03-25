package day0323;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] f = new int[n][3];

		f[0][0] = sc.nextInt();
		f[0][1] = sc.nextInt();
		f[0][2] = sc.nextInt();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int p = sc.nextInt();
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (j == k)
						continue;

					if (f[i - 1][k] + p < min)
						min = f[i - 1][k] + p;
				}

				f[i][j] = min;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (f[n - 1][i] < min)
				min = f[n - 1][i];
		}

		System.out.println(min);
	}
}
