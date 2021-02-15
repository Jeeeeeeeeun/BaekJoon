package day0215;

import java.util.Scanner;

public class Main_3040_백설공주와일곱난쟁이 {
	static int[] selected = new int[7];
	static int[] dwarf = new int[9];

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(
				"8\r\n" + "6\r\n" + "5\r\n" + "1\r\n" + "37\r\n" + "30\r\n" + "28\r\n" + "22\r\n" + "36");

		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}

		combination(0, 0);
	}

	static void combination(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}

			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
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
