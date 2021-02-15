package day0215;

import java.util.Arrays;
import java.util.Scanner;

class Store {
	int dir;
	int block;

	Store(int dir, int block) {
		this.dir = dir;
		this.block = block;
	}
}

public class Main_2564_경비원 {
	static int H, W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		W = sc.nextInt(); // 가로 길이
		H = sc.nextInt(); // 세로 길이

		int N = sc.nextInt(); // 상점 개수
		Store[] stores = new Store[N]; // 상점 배열
		for (int i = 0; i < N; i++) {
			stores[i] = new Store(sc.nextInt(), sc.nextInt());
		}

		Store current = new Store(sc.nextInt(), sc.nextInt()); // 현재좌표

		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 같은 방향인 경우
			if (current.dir == stores[i].dir) {
				sum += Math.abs(current.block - stores[i].block);
			}

			// 마주보는 경우
			else if (Math.abs(current.dir - stores[i].dir) == 1 //차가 1인 경우 중
					&& ((current.dir != 2 || stores[i].dir != 3) && (current.dir != 3 || stores[i].dir != 2))) { // 2&3인 경우 제외
				if (current.dir == 1 || current.dir == 2) { // 남북
					sum += Math.min(H + current.block + stores[i].block, H + (2 * W) - current.block - stores[i].block); // 반시계,시계
				} else { // 동서
					sum += Math.min(W + current.block + stores[i].block, W + (2 * H) - current.block - stores[i].block); // 반시계,시계
				}
			}

			// 옆에 위치하는 경우
			else {
				// 좌표값으로 계산
				int[] c = getPos(current.dir, current.block);
				int[] s = getPos(stores[i].dir, stores[i].block);
				sum += Math.abs(c[0] - s[0]) + Math.abs(c[1] - s[1]);
			}
		}

		System.out.println(sum);
	}

	// 좌표값 리턴
	public static int[] getPos(int dir, int block) { 
		int tx = 0, ty = 0;
		switch (dir) {
		case 1: tx = 0; ty = block; break;
		case 2: tx = H; ty = block; break;
		case 3: tx = block; ty = 0; break;
		case 4: tx = block; ty = W; break;
		}

		return new int[] { tx, ty };
	}
}
