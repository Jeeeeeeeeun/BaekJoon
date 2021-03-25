package day0323;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] f = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;

			// -1 연산
			min = 1 + f[i - 1];

			// /3연산
			if (i % 3 == 0 && 1 + f[i / 3] < min) {
				min = 1 + f[i / 3];
			}

			// /2연산
			if (i % 2 == 0 && 1 + f[i / 2] < min) {
				min = 1 + f[i / 2];
			}

			f[i] = min;
		}

		System.out.println(f[n]);

	}
}
