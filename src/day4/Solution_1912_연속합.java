package day4;

import java.util.Scanner;

public class Solution_1912_연속합 {
	static int N;
	static int[] arr;
	static boolean[] isSelected;
	static int max = 0;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("10\r\n" + "10 -4 3 1 5 6 -35 12 21 -1");
		N = sc.nextInt();
		arr = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		subset(0);

		System.out.println(max);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					sum += arr[i];
			}

			if (sum > max)
				max = sum;
			
			System.out.println(max);

			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);

		isSelected[cnt] = false;
		subset(cnt + 1);
	}
}
