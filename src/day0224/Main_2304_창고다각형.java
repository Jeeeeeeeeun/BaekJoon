package day0224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Pillar {
	int L;
	int H;

	public Pillar(int l, int h) {
		L = l;
		H = h;
	}
}

public class Main_2304_창고다각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 기둥 개수
		List<Pillar> pillars = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			pillars.add(new Pillar(sc.nextInt(), sc.nextInt()));
		}

		// 왼쪽부터 정렬
		pillars.sort((a, b) -> {
			return a.L - b.L;
		});

		for (int i = 0; i < N; i++) {
			System.out.println(pillars.get(i).L + " " + pillars.get(i).H);
		}

		// 가장 높은 기둥 찾기
		int max = 0;
		int maxIdx = -1;
		for (int i = 0; i < N; i++) {
			if (max < pillars.get(i).H) {
				max = pillars.get(i).H;
				maxIdx = i;
			}
		}

		System.out.println("max " + max + " " + maxIdx);

		int leftSum = 0;
		int high = 0; // 현재까지 가장 높은 기둥
		for (int i = 0; i < maxIdx; i++) {
			if (pillars.get(i).H > high) {
				high = pillars.get(i).H;
			}
			leftSum += high;
		}

		System.out.println("leftSum " + leftSum);

		int rightSum = 0;
		high = 0;
		for (int i = N - 1; i >= maxIdx; i--) {
			if (pillars.get(i).H > high) {
				high = pillars.get(i).H;
			}
			rightSum += high;
		}
		System.out.println("rightSum " + rightSum);

		System.out.println(pillars.get(maxIdx).H + leftSum + rightSum);

	}
}
