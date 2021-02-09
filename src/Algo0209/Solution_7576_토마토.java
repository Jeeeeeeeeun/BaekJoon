package Algo0209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int day;

	public Tomato(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Solution_7576_토마토 {
	static int[][] box;
	static int N, M;
	static int day = 0;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\Algo0209\\tomato.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st2.nextToken());
			}

		}
		bfs();

		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}

		System.out.println(flag ? day : -1);
	}

	public static void bfs() {
		Queue<Tomato> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1)
					queue.offer(new Tomato(i, j, 0));
			}
		}

		while (!queue.isEmpty()) {
			Tomato t = queue.poll();
			day = t.day;
			
			//4방탐색
			for (int i = 0; i < 4; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;

				if (box[x][y] != 0)
					continue;

				box[x][y] = 1;
				queue.offer(new Tomato(x, y, t.day + 1));
			}
		}
	}
}
