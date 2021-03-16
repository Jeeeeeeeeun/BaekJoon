package day0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1941_소문난칠공주 {
	static char[][] students;
	static int[] pick = new int[7];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		students = new char[5][];

		for (int i = 0; i < 5; i++) {
			students[i] = br.readLine().toCharArray();
		}

		combination(0, 0);
		
		System.out.println(answer);

	}

	public static void combination(int cnt, int start) {
		if (cnt == 7) {
//			System.out.println(Arrays.toString(pick));

			// x y좌표 변환
			int sCnt = 0;
			int[][] loc = new int[7][2];
			boolean[][] visited = new boolean[5][5];
			for (int i = 0; i < 7; i++) {
				int x = pick[i] / 5;
				int y = pick[i] % 5;

				loc[i][0] = x;
				loc[i][1] = y;

				visited[x][y]=true;
				
				// S개수 검사
				if (students[x][y] == 'S') {
					sCnt++;
				}
			}
			if (sCnt < 4)
				return;

			System.out.println(Arrays.toString(pick));
			// 7개가 붙어있는지 검사
			
			
			for (int i = 1; i < loc.length; i++) {
				if ((loc[i][0] == loc[i - 1][0] + 1 && loc[i][1] == loc[i - 1][1])
						|| (loc[i][0] == loc[i - 1][0] && loc[i][1] == loc[i - 1][1] + 1)) {
					continue;
				} else {
					return;
				}
			}

			answer++;
			return;
		}

		for (int i = start; i < 25; i++) {
			pick[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}
}
