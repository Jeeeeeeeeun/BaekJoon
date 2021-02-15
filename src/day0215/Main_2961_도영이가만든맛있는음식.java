package day0215;

import java.util.Scanner;

public class Main_2961_도영이가만든맛있는음식 {
	static int[] sour, bitter;
	static boolean[] isSelected;
	static int N = 1;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}

		subset(0);

		System.out.println(answer);

	}

	static void subset(int cnt) {
		if (cnt == N) {
			int sSum = 1, bSum = 0;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sSum *= sour[i];
					bSum += bitter[i];
				}
			}

			if (sSum == 1 && bSum == 0) // 공집합
				return;

			int result = Math.abs(sSum - bSum);

			if (result < answer)
				answer = result;

			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
}
