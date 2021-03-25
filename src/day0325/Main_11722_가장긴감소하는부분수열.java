package day0325;

import java.util.Scanner;

public class Main_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] LDS = new int[N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			LDS[i] = 1;
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] > arr[i] && LDS[i] < LDS[j] + 1) {
					LDS[i] = LDS[j] + 1;
				}
			}
			if (LDS[i] > max) {
				max = LDS[i];
			}
		}

		System.out.println(max);
	}
}
