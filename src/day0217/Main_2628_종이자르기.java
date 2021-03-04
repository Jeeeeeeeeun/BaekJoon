package day0217;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner("10 8\r\n" + "3\r\n" + "0 3\r\n" + "1 4\r\n" + "0 2");

		int R = sc.nextInt(); // row
		int C = sc.nextInt(); // col

		int cut = sc.nextInt();

		ArrayList<Integer> horizon = new ArrayList<>(); // 가로
		ArrayList<Integer> vertical = new ArrayList<>(); // 세로

		// 시작점
		horizon.add(0);
		vertical.add(0);

		for (int i = 0; i < cut; i++) {
			if (sc.nextInt() == 0) { // 가로
				horizon.add(sc.nextInt());
			} else { // 세로
				vertical.add(sc.nextInt());
			}
		}

		// 끝점
		horizon.add(C);
		vertical.add(R);

		// 정렬
		Collections.sort(horizon);
		Collections.sort(vertical);

		int max = 0;

		for (int i = 1; i < horizon.size(); i++) {
			int height = horizon.get(i) - horizon.get(i - 1); // 세로길이
			for (int j = 1; j < vertical.size(); j++) {
				int width = vertical.get(j) - vertical.get(j - 1); // 가로길이

				int size = height * width;

				if (max < size) {
					max = size;
				}
			}
		}

		System.out.println(max);
	}
}
