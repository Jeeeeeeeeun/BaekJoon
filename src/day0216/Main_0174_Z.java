package day0216;

import java.util.Scanner;

public class Main_0174_Z {
	static int N;
	static int r, c;
	static int start = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 2^N
		r = sc.nextInt(); // 행
		c = sc.nextInt(); // 열

		while (true) {
			int size = (int) Math.pow(2, N);

			if (r < size / 2 && c < size / 2) { // 1사분면

			} else if (r < size / 2 && c >= size / 2) { // 2사분면
				start += (int) Math.pow(4, N - 1); // 시작 숫자 다시 지정
				c -= size / 2; // 시작 위치 다시 지정
			} else if (r >= size / 2 && c < size / 2) { // 3사분면
				start += (int) Math.pow(4, N - 1) * 2;
				r -= size / 2; // 시작 위치 다시 지정
			} else if (r >= size / 2 && c >= size / 2) { // 4사분면
				start += (int) Math.pow(4, N - 1) * 3;
				r -= size / 2; // 시작 위치 다시 지정
				c -= size / 2;
			}
			N--;

			if (N == 0) {
				System.out.println(start);
				break;
			}
		}

	}
}
