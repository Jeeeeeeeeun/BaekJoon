package day0305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_수리공항승 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 물 새는 곳
		int L = Integer.parseInt(st.nextToken()); // 테이프길이

		int[] pipe = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pipe);
		
		int start = pipe[0]; // 테이프 시작 위치 - 앞에서부터 붙이기
		int cnt = 1; // 테이프 개수

		for (int i = 1; i < N; i++) {
			if (pipe[i] - start <= L - 1) { // 테이프 시작 위치로부터 길이가 L-1
				continue;
			} else {
				cnt++;
				start = pipe[i];
			}
		}
		
		System.out.println(cnt);
	}
}
