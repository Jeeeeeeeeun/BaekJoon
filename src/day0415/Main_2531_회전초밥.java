package day0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] dishes = new int[N];
		for (int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		int[] selected = new int[k + 1];

		int max = 0;

		// 뽑기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < k; j++) {
				selected[j] = dishes[(i + j) % N];
			}
			selected[k] = c; // 마지막=쿠폰

			Arrays.sort(selected);

			int cnt = 0;
			for (int j = 0; j < k + 1; j++) {
				if (j == 0) {
					cnt++;
					continue;
				}

				if (selected[j - 1] != selected[j])
					cnt++;
			}
			if (max < cnt) {
				max = cnt;
			}
		}

		System.out.println(max);

	}
}
