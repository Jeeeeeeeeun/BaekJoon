package day0304;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606_바이러스 {

	static int computer;
	static boolean[][] connected;
	static boolean[] infected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();
		int pair = sc.nextInt();

		connected = new boolean[computer][computer];
		infected = new boolean[computer];

		// n x n 배열
		for (int i = 0; i < pair; i++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			connected[c1 - 1][c2 - 1] = true;
			connected[c2 - 1][c1 - 1] = true;
		}

		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		infected[0] = true; // 넣을 때 감염된것으로 표시

		while (queue.size() != 0) {
			int num = queue.poll(); // 뽑아서

			for (int i = 0; i < computer; i++) {
				if (connected[num][i] && !infected[i]) { // 인접 & 감염X인것 넣기 & 감염된것으로 표시
					queue.offer(i);
					infected[i] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i < infected.length; i++) {
			if (infected[i]) {
				cnt++;
			}
		}

		return cnt;
	}
}
