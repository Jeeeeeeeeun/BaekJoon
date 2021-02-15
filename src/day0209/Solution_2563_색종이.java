package day0209;

import java.util.Scanner;

public class Solution_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner("3\r\n" + "3 7\r\n" + "15 7\r\n" + "5 2");

		int N = sc.nextInt();

		int[][] paper = new int[100][100];

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (paper[x + j][y + k] == 0) {
						paper[x + j][y + k] = 1;
						cnt++;
					}
				}
			}

		}
		System.out.println(cnt);
	}
}
