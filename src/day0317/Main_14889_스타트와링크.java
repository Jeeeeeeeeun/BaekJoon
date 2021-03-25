package day0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int[][] power;

	static int sum1 = 0, sum2 = 0;
	static int diff = Integer.MAX_VALUE;
	static int[] choose1, choose2;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		choose1 = new int[N / 2];
		choose2 = new int[N / 2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(diff);

	}

	private static void dfs(int cnt, int current) {
		if (cnt == N / 2) {
			int team1Sum = 0, team2Sum = 0;

			// team1
			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					team1Sum += (power[choose1[i]][choose1[j]] + power[choose1[j]][choose1[i]]);
				}
			}

			// team2
			int cnt2 = 0;
			for (int i = 0; i < N; i++) {
				boolean check = true;

				for (int j = 0; j < N / 2; j++) {
					if (i == choose1[j]) {
						check = false;
						break;
					}
				}
				if (check) {
					choose2[cnt2++] = i;
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					team2Sum += (power[choose2[i]][choose2[j]] + power[choose2[j]][choose2[i]]);
				}
			}

			if (diff > Math.abs(team1Sum - team2Sum)) {
				diff = Math.abs(team1Sum - team2Sum);
			}
			return;
		}

		for (int i = current; i < N; i++) {
			choose1[cnt] = i;
			dfs(cnt + 1, i + 1);
		}

	}
}
