package day0209;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MiroTest {
	static int[][] map;
	static boolean[][] isVisited;
	static int N;
	static int cnt;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\Algo0209\\Miro.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			map = new int[N][N];
			isVisited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			if (map[N - 1][N - 1] != 0) {
				System.out.println("#" + test + "  -1");
				continue;
			}

			bfs();

			System.out.println("#" + test + " " + cnt);
			cnt = 0;

		}
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		queue.offer(new Node(0, 0, 0));
		int currX, currY;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			currX = node.x;
			currY = node.y;
			isVisited[currX][currY] = true;

			for (int i = 0; i < 4; i++) {
				int x = currX + dx[i];
				int y = currY + dy[i];

				if (x < 0 || y < 0 || x >= N || y >= N)
					continue;

				if (map[x][y] == 0 && !isVisited[x][y]) {
					queue.offer(new Node(x, y, node.depth + 1));
				}

				if (isVisited[N - 1][N - 1]) {
					cnt = node.depth;
					break;
				}
			}

		}
	}

}

class Node {
	int x, y, depth;

	public Node(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}
