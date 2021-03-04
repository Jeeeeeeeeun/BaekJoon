package day0225;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_일곱난쟁이 {
	static int[] dwarf = new int[9];
	static int[] selected = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}

		combination(0, 0);

	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;

			for (int i = 0; i < selected.length; i++) {
				sum += selected[i];
			}

			if (sum == 100) {
				Arrays.sort(selected);

				for (int n : selected) {
					System.out.println(n);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			selected[cnt] = dwarf[i];
			combination(cnt + 1, i + 1);
		}
	}
}
