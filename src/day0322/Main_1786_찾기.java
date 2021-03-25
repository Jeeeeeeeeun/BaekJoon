package day0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기 {
	static int cnt = 0;
	static List<Integer> list;

	static int[] getP(String pattern) {
		int[] p = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = p[j - 1];
			}

			if (pattern.charAt(i) == pattern.charAt(j)) {
				p[i] = ++j;
			}
		}
		return p;
	}

	static void KMP(String origin, String pattern) {
		int p[] = getP(pattern);

		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = p[j - 1];
			}

			if (origin.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					++cnt;
					list.add(i - j + 1);
					j = p[j];
				} else {
					j++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		list = new ArrayList<>();
		KMP(origin, pattern);
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++)
			System.out.println(list.get(i));
	}
}