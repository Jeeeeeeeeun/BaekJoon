package day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int length = 1;
		// 오름차순
		for (int i = 0; i < N; i++) {
			if (i != N - 1 && numbers[i] <= numbers[i + 1]) {
				length++;
				continue;
			} else {
				if (max < length) max = length;
				length = 1;
			}
		}

		// 내림차순
		length = 1;
		for (int i = 0; i < N; i++) {
			if (i != N - 1 && numbers[i] >= numbers[i + 1]) {
				length++;
				continue;
			} else {
				if (max < length) max = length;
				length = 1;
			}
		}

		System.out.println(max);
	}
}
