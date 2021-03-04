package day0224;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 면적당 참외 개수

		List<Integer> dir = new ArrayList<>(); // 방향
		List<Integer> len = new ArrayList<>(); // 길이

		int maxWLen = 0;
		int maxWIdx = 0;

		int maxHLen = 0;
		int maxHIdx = 0;

		for (int i = 0; i < 6; i++) {
			int d = sc.nextInt();
			int l = sc.nextInt();

			// 세로
			if (d == 1 || d == 2) {
				if (maxWLen < l) {
					maxWIdx = i;
					maxWLen = l;
				}
			} else { // 가로
				if (maxHLen < l) {
					maxHIdx = i;
					maxHLen = l;
				}
			}

			dir.add(d);
			len.add(l);
		}

		int smallWIdx = maxWIdx + 3 < 6 ? maxWIdx + 3 : maxWIdx + 3 - 6;
		int smallHIdx = maxHIdx + 3 < 6 ? maxHIdx + 3 : maxHIdx + 3 - 6;

		int bigBox = maxHLen * maxWLen;
		int smallBox = len.get(smallHIdx) * len.get(smallWIdx);

		System.out.println((bigBox - smallBox) * K);
	}
}
