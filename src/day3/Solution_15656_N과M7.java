package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_15656_N과M7 {
	static int N;
	static int R;

	static int[] list;
	static int[] numbers;

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();

		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);

		numbers = new int[R];

		permutation(0);
		
		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			numbers[cnt] = list[i];

			permutation(cnt + 1);
		}

	}
}
