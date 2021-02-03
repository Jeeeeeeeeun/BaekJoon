package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_15651_N과M3 {
	static int N;
	static int R;

	static int[] numbers;
//	static boolean[] isSelected;
	static StringBuffer sb = new StringBuffer(); // 기존 sysout 그냥 쓰면 시간초과남 -> sb로 해결

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R];
//		isSelected = new boolean[N+1];

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

		for (int i = 1; i <= N; i++) {
//			if (isSelected[i]) continue;

			numbers[cnt] = i;
//			isSelected[i] = true;

			permutation(cnt + 1);
//			isSelected[i] = false;
		}

	}
}
