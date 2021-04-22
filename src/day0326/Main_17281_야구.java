package day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281_야구 {

	static int N;
	static int[][] scores;
	static int[] order = new int[9]; // 타순
	static boolean[] visited = new boolean[9];
	static int maxScore = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		scores = new int[N][9];
		order[3] = 0; // 4번타자는 1번으로 고정

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permute(0);

		System.out.println(maxScore);

	}

	// 순열
	private static void permute(int cnt) {
		if (cnt == 9) {
			// 경기 진행
			int playerPtr = 0; // order 순서 가리킬 포인터
			int totalScore = 0;

			// 각 이닝
			for (int i = 0; i < N; i++) {
				int out = 0;
				boolean[] base = new boolean[3]; // 1루, 2루, 3루

				while (out < 3) {
					int player = order[playerPtr]; // 선수
					int score = scores[i][player]; // 선수가 이번 이닝에 낼 점수

					// 아웃
					if (score == 0) {
						out++;
						// 다음타자
						playerPtr = (playerPtr + 1) % 9;
						continue;
					}

					// 점수 냈을 때
					// 기존 인원 진루
					for (int j = 2; j >= 0; j--) {
						if (base[j]) { // 해당 base에 사람 있 (true면)
							base[j] = false;
							if (j + score >= 3) { // 득점이면 점수를 한점 올림
								totalScore++;
							} else { // 아니면 진루 -> score만큼 떨어진
								base[j + score] = true;
							}
						}
					}
					// 새 주자 진루
					if (score == 4) {
						totalScore++;
					} else {
						base[score - 1] = true;
					}

					// 다음타자
					playerPtr = (playerPtr + 1) % 9;
				}
			}

			// 최대 점수
			if (totalScore > maxScore) {
				maxScore = totalScore;
			}

			return;
		}

		// 2번타자 (1번인덱스)부터
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				order[cnt] = i;
				visited[i] = true;
				if (cnt + 1 == 3) {
					permute(cnt + 2);
				} else {
					permute(cnt + 1);
				}
				visited[i] = false;
			}
		}
	}
}
