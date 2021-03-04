package day0226;

import java.util.Scanner;

public class Main_10157_자리배정 {

	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int search = sc.nextInt();

		boolean[][] seats = new boolean[R][C];
		int currX = 0;
		int currY = 0;
		int dir = 0;
		seats[0][0] = true;

		if (search > R * C) {
			System.out.println(0);
			return;
		}

		for (int i = 1; i < search; i++) {
			currX += dx[dir];
			currY += dy[dir];

			if (currX < 0 || currY < 0 || currX >= R || currY >= C || seats[currX][currY]) {
				currX -= dx[dir];
				currY -= dy[dir];

				// 방향 전환
				dir = (dir + 1) % 4;
				currX += dx[dir];
				currY += dy[dir];
			}

			seats[currX][currY] = true;
		}

		System.out.println((currX + 1) + " " + (currY + 1));

	}
}
