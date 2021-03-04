package day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	static int[][] map;
	static boolean[][] bingo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[5][5];
		bingo = new boolean[5][5];

		// 철수
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				cnt++;
				check(num);

				if (isEnd()) {
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	private static boolean isEnd() {
		int bingoCnt = 0;

		// 가로
		boolean flag;
		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == false) {
					flag = false;
					break;
				}
			}

			if (flag)
				bingoCnt++;
		}

		if (bingoCnt >= 3)
			return true;

		// 세로
		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (bingo[j][i] == false) {
					flag = false;
					break;
				}
			}

			if (flag)
				bingoCnt++;
		}

		if (bingoCnt >= 3)
			return true;

		// 대각선
		flag = true;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] == false) {
				flag = false;
				break;
			}
		}
		if (flag)
			bingoCnt++;
		if (bingoCnt >= 3)
			return true;

		flag = true;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][4 - i] == false) {
				flag = false;
				break;
			}
		}
		if (flag)
			bingoCnt++;
		if (bingoCnt >= 3)
			return true;
		else
			return false;
	}

	private static void check(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == num) {
					bingo[i][j] = true;
					return;
				}
			}
		}

	}
}
