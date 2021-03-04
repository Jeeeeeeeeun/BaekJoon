package day0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C, max = 0;
	static char[][] map;
	static ArrayList<Character> charList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 시작점 방문
		charList.add(map[0][0]);
		dfs(1, 0, 0);

		System.out.println(max);
	}

	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	private static void dfs(int cnt, int x, int y) {
		boolean isEnd = true;

		for (int i = 0; i < 4; i++) {
			int r = x + dx[i];
			int c = y + dy[i];

			if (r < 0 || c < 0 || r >= R || c >= C)
				continue; // 범위 밖

			if (charList.indexOf(map[r][c]) == -1) {
				charList.add(map[r][c]);
				isEnd = false;
				dfs(cnt + 1, r, c);
				charList.remove(charList.indexOf(map[r][c]));
			}
		}

		// 4방 다 갈곳 X
		if (isEnd) {
			if (max < cnt) {
				max = cnt;
			}
			return;
		}
	}

}
