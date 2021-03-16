package day0316;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1759_암호만들기 {
	static int L, C;
	static char[] letters;
	static char[] answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		answer = new char[L];
		C = sc.nextInt();
		letters = new char[C];

		for (int i = 0; i < C; i++) {
			letters[i] = sc.next().charAt(0);
		}
		Arrays.sort(letters);

		dfs(0, 0);
	}

	private static void dfs(int start, int cnt) {
		if (cnt == L) {
			// 한개의 모음 & 두개의 자음
			char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

			int vCnt = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < vowel.length; j++) {
					if (answer[i] == vowel[j]) {
						vCnt++;
						break;
					}
				}
			}
			if (vCnt < 1 || vCnt > L - 2)
				return;

			for (int i = 0; i < L; i++) {
				System.out.print(answer[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i < C; i++) {
			answer[cnt] = letters[i];
			dfs(i + 1, cnt + 1);
		}

	}
}
