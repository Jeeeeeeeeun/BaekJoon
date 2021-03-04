package day0224;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수
		List<Integer> line = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int number = sc.nextInt();
			line.add(line.size() - number, i);
		}

		// 출력
		for (int a : line) {
			System.out.print(a + " ");
		}

	}
}
