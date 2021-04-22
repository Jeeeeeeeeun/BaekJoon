package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1339_단어수학 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];

		int[] alphabets = new int[26];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();

			int len = words[i].length();
			for (int j = 0; j < len; j++) {
				char curr = words[i].charAt(j);

				alphabets[curr - 'A'] += Math.pow(10, len - j - 1);
			}
		}

		Arrays.sort(alphabets);

		int sum = 0;
		int n = 9;
		for (int i = 0; i < 10; i++) {
			sum += alphabets[25 - i] * n--;
		}

		System.out.println(sum);
	}
}
