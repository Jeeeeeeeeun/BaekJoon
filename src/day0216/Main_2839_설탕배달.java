package day0216;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int w5 = 0, w3 = 0;
		while (N > 0) {
			if ((N % 5 != 0 && N % 3 != 0) || (N % 5 == 0)) {
				w5++;
				N -= 5;
			} else if (N % 3 == 0) {
				w3++;
				N -= 3;
			}

			if (N < 0) {
				System.out.println(-1);
				System.exit(0);
			}
		}

		System.out.println(w3 + w5);

	}
}
