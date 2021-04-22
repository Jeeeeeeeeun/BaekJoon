package day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int map[][];
	static int R, C;
	static int[] cTop, cBottom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정보 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // row
		C = Integer.parseInt(st.nextToken()); // col
		int T = Integer.parseInt(st.nextToken()); // 초
		map = new int[R][C];
		cTop = new int[2]; // 공청기 위치(top) - x,y
		cBottom = new int[2]; // 공청기 위치(bottom) - x, y
		int cCnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 공청기 위치 저장
				if (map[i][j] == -1) {
					if (cCnt == 0) {
						cTop[0] = i;
						cTop[1] = j;
						cCnt++;
					} else {
						cBottom[0] = i;
						cBottom[1] = j;
					}
				}
			}
		}

		// 확산 & 공청기
		for (int t = 0; t < T; t++) {
			scatter();
			circulate();
		}

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt += map[i][j];
			}
		}

		System.out.println(cnt);

	}

	static int[] dxT = { -1, 0, 1, 0 };
	static int[] dyT = { 0, 1, 0, -1 };

	static int[] dxB = { 1, 0, -1, 0 };
	static int[] dyB = { 0, 1, 0, -1 };

	private static void cir(boolean isTop, int[] cLoc, int[] dx, int[] dy) {
		int currX = cLoc[0];
		int currY = cLoc[1];
		int d = 0;
		while (true) {
			int nx = currX + dx[d];
			int ny = currY + dy[d];

			if (nx == cLoc[0] && ny == cLoc[1])
				break;

			if (isTop) {
				if (nx < 0 || ny < 0 || nx > cLoc[0] || ny >= C) {
					d = (d + 1) % 4;
					continue;
				}
			} else {
				if (nx < 0 || ny < 0 || nx < cLoc[0] || nx >= R || ny >= C) {
					d = (d + 1) % 4;
					continue;
				}
			}

			if (currX == cLoc[0] && currY == cLoc[1]) {
				map[currX][currY] = 0;
			} else {
				map[currX][currY] = map[nx][ny]; // 빨아들이기
			}

			currX = nx;
			currY = ny;
		}
		map[cLoc[0]][cLoc[1] + 1] = 0;
	}

	private static void circulate() {
		cir(true, cTop, dxT, dyT);
		cir(false, cBottom, dxB, dyB);
	}

	private static void scatter() {
		// int배열 - {x, y, 미세먼지 수치}
		Queue<int[]> queue = new LinkedList<>();

		// queue에 삽입
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] < 5)
					continue;

				queue.offer(new int[] { i, j, map[i][j] });
			}
		}

		// 확산
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cx = curr[0];
			int cy = curr[1];
			int amount = curr[2];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dxT[i];
				int ny = cy + dyT[i];

				// 확산 X경우
				if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1)
					continue;

				// 확산O
				int dust = amount / 5;
				map[nx][ny] += dust;
				map[cx][cy] -= dust;
			}
		}
	}
}
