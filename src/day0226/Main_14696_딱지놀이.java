package day0226;

import java.util.Scanner;

public class Main_14696_딱지놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int round = sc.nextInt();

		for (int r = 0; r < round; r++) {
			int a = sc.nextInt();
			int[] aCards = new int[5]; // 인덱스 1,2,3,4 = 세,네,동,별 cnt
			for (int i = 0; i < a; i++) {
				aCards[sc.nextInt()]++;
			}

			int b = sc.nextInt();
			int[] bCards = new int[5]; // 인덱스 1,2,3,4 = 세,네,동,별 cnt
			for (int i = 0; i < b; i++) {
				bCards[sc.nextInt()]++;
			}

			if (aCards[4] != bCards[4]) {
				char win = aCards[4] > bCards[4] ? 'A' : 'B';
				System.out.println(win);
			} else if (aCards[3] != bCards[3]) {
				char win = aCards[3] > bCards[3] ? 'A' : 'B';
				System.out.println(win);
			} else if (aCards[2] != bCards[2]) {
				char win = aCards[2] > bCards[2] ? 'A' : 'B';
				System.out.println(win);
			} else if (aCards[1] != bCards[1]) {
				char win = aCards[1] > bCards[1] ? 'A' : 'B';
				System.out.println(win);
			} else {
				System.out.println('D');
			}

		}

	}
}
