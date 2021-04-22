// https://huiung.tistory.com/121
// https://rile1036.tistory.com/144

package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2281_데스노트 {
	static int n, m;
	static int[] names;
	static int[][] dp = new int[1002][1002]; // 남는칸 제곱의 합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 이름 개수
		m = Integer.parseInt(st.nextToken()); // 노트 가로 칸 개수

		// 이름 배열
		names = new int[n];
		for (int i = 0; i < n; i++) {
			names[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 1002; i++) {
			Arrays.fill(dp[i], -1); // dp 초기화
		}

		int answer = solution(1, names[0] + 1); // 인덱스, 현재 라인의 글자 길이 (공백 포함)

		System.out.println(answer);
	}

	private static int solution(int index, int len) {
		if (index >= n)
			return 0; // 이름 끝까지 다 구한 경우

		if (dp[index][len] != -1)
			return dp[index][len]; // 이미 구해져 있는 경우

		// 다음 행에 다음 이름 작성
		dp[index][len] = (m - len + 1) * (m - len + 1) + solution(index + 1, names[index] + 1); 

		// 이번 행에 다음 이름 작성
		if (len + names[index] <= m) {
			// 이미 저장된 값(다음행에 작성) vs 이번행에 작성한 경우
			dp[index][len] = Math.min(dp[index][len], solution(index + 1, len + names[index] + 1));
		}

		return dp[index][len];
	}
}
