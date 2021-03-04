package day0225;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10163_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[101][101];

		int N = sc.nextInt();// 색종이 개수
		int[] cnt = new int[N];

		for (int p = 1; p <= N; p++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int width = sc.nextInt() - 1;
			int height = sc.nextInt() - 1;

			for (int i = startX; i <= startX + width; i++) {
				for (int j = startY; j <= startY + height; j++) {
					paper[i][j] = p;
				}
			}
		}

		for (int p = 1; p <= N; p++) {
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (paper[i][j] == p) {
						cnt[p - 1]++;
					}
				}
			}

		}

		for (int n : cnt) {
			System.out.println(n);
		}

	}
}
