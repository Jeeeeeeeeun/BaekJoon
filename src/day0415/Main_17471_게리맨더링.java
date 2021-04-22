package day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int N;
	static boolean[][] adjM;
	static int[] populations;

	static boolean[] selected;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 구역 개수

		// 인구수 정보
		populations = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			populations[i] = Integer.parseInt(st.nextToken());
		}
		selected = new boolean[N + 1];

		// 인접행렬 완성
		adjM = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int n = Integer.parseInt(st.nextToken());
				adjM[i][n] = true;
				adjM[n][i] = true;
			}
		}

		combination(1, 0);

		System.out.println(Min == Integer.MAX_VALUE ? -1 : Min);
	}

	private static void bfs(boolean[] visited, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 1; i <= N; i++) {
				// 연결 X
				if (!adjM[curr][i])
					continue;
				// 같은 구X
				if (selected[start] != selected[i])
					continue;

				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}

		}
	}

	private static void combination(int start, int cnt) {
		if (cnt == N) {
			int sel = -1;
			int notSel = -1;

			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					sel = i;
				} else {
					notSel = i;
				}
			}

			if (sel == -1 || notSel == -1)
				return;

			// bfs
			boolean[] visited = new boolean[N + 1];
			bfs(visited, sel); // 선택한 조합 bfs
			bfs(visited, notSel); // 선택X 조합 bfs

			// 만약 선택 + 비선택으로 각각 bfs해서 전체 정점 다 방문 X면 그래프 연결 안된것
			for (int i = 1; i <= N; i++) {
				if (!visited[i])
					return;
			}

			// 인구수 차 구하기
			int selSum = 0; // 선택 인구수 합
			int nSelSum = 0; // 비선택 인구수 합
			for (int i = 1; i <= N; i++) {
				if (selected[i])
					selSum += populations[i];
				else
					nSelSum += populations[i];
			}
			int gap = Math.abs(selSum - nSelSum);
			if (gap < Min) // 최소값 갱신
				Min = gap;

			return;
		}

		for (int i = start; i <= N; i++) {
			selected[i] = true;
			combination(i + 1, cnt + 1);

			selected[i] = false;
			combination(i + 1, cnt + 1);
		}

	}
}
