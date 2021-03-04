package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static int[][] simul;
	static int[] archer = new int[3];

	static int maxKill = 0;
	static int archerX = N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		simul = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0);

		System.out.println(maxKill);

	}

	private static int killEnemy() {
		int kill = 0;
		ArrayList<int[]> enemy = new ArrayList<>();

		for (int a = 0; a < 3; a++) { // 궁수 3명
			int archerY = archer[a];

			if (D == 1) { // 거리 1일때
				if (simul[archerX - 1][archerY] == 1) {
					enemy.add(new int[] { archerX - 1, archerY });
				}
			} else { // 거리 2 이상일 때
				for (int i = 1; i <= D - 1; i++) { // 가까운 거리부터 적 찾기
					boolean isKilled = false;
					for (int j = 1; j <= (i * 2) + 1; j++) {
						int x = archerX - (i + 1 - Math.abs((i + 1) - j));
						int y = archerY + ((i * -1) + j - 1);

						if (x < 0 || x >= archerX || y < 0 || y >= M)
							continue;

						if (simul[x][y] == 1) {
							enemy.add(new int[] { x, y });
							isKilled = true;
							break;
						}

					}
					if (isKilled)
						break;
				}
			}

			for (int i = 0; i < enemy.size(); i++) {
				int[] tmp = enemy.get(i);

				if (simul[tmp[0]][tmp[1]] == 1) {
					simul[tmp[0]][tmp[1]] = 0;
					System.out.println("x, y : " + tmp[0] + tmp[1]);
					kill++;
				}
			}
		}

		return kill;
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(archer));
			archerX = N;
			int kill = 0;

			// 배열복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					simul[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				System.out.println("round" + (i + 1));
				System.out.println(archerX);
				kill += killEnemy();
				archerX--;

				for (int[] m : simul) {
					System.out.println(Arrays.toString(m));
				}
			}

			if (kill > maxKill) {
				maxKill = kill;
			}

			return;
		}

		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

}
