package day0416;

import java.util.Scanner;

public class Main_16953_AB {
	static long B;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		B = sc.nextLong();

		solution(A, 1);

		System.out.println(min == Long.MAX_VALUE ? -1 : min);
	}

	private static void solution(long a, int cnt) {
		if (a == B) {
			// 답 찾으면 cnt값 비교해서 최소값 갱신
			if (min > cnt) {
				min = cnt;
			}
			return;
		} else if (a > B) { // 더 커지면 끝
			return;
		}

		solution(a * 2, cnt + 1); // x2
		solution((a * 10) + 1, cnt + 1); // 끝자리에 1 추가
	}
}
