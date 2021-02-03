package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_15650_N과M2 {
	static int[] numbers;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R];

		combination(0, 1);

	}

	static void combination(int cnt, int start) {
		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println("");

			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
