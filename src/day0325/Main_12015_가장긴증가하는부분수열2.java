package day0325;

import java.util.Arrays;
import java.util.Scanner;

public class Main_12015_가장긴증가하는부분수열2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] LIS = new int[N];

		int size = 0; // 헌재 LIS의 길이값

		for (int i = 0; i < N; i++) {
			int n = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if (n >= 0)
				continue; // 중복값

			n = Math.abs(n) - 1; // 원래 자기 자리
			LIS[n] = arr[i];

			if (n == size) {
				++size;
			}
		}

		System.out.println(size);
	}
}
