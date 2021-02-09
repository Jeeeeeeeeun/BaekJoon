package Algo0209;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1158_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 3");

		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int p = 0;
		while (list.size() != 1) {
			p = (p + K - 1) % N;
			N--;
			sb.append(list.get(p) + ", ");
			list.remove(p);
		}
		sb.append(list.get(0) + ">");
		System.out.println(sb);

	}
}
