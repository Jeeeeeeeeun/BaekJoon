package day0226;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2635_수이어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int maxSize = 0;
		List<Integer> array = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		for (int num = N; num > 0; num--) {
			array.add(N);
			array.add(num);
			while (true) {
				int n = array.get(array.size() - 2) - array.get(array.size() - 1);

				if (n < 0) {
					if (array.size() >= maxSize) {
						maxSize = array.size();

						answer.clear();
						for (int i = 0; i < array.size(); i++) {
							answer.add(array.get(i));
						}
					}
					array.clear();
					break;
				} else {
					array.add(n);
				}
			}
		}

		System.out.println(maxSize);

		for (int n : answer) {
			System.out.print(n + " ");
		}

	}
}
