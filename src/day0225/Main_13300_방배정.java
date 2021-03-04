package day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 전체 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방 최대 인원 수

		int[][] cnt = new int[7][2]; // 학년,성별

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()); // 성별
			int y = Integer.parseInt(st.nextToken()); // 학년
			cnt[y][s]++;
		}

		int room = 0;

		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (cnt[i][j] == 0)
					continue;

				room += cnt[i][j] / K;

				if (cnt[i][j] % K != 0) {
					room++;
				}
			}
		}

		System.out.println(room);

	}
}
