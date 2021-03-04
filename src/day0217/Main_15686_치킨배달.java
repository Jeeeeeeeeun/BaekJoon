package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static class Building {
		int x;
		int y;

		public Building(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;

	static ArrayList<Building> home = new ArrayList<>();
	static ArrayList<Building> chicken = new ArrayList<>();
	static Building[] selected;
	static int chickenDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new Building[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) {
					home.add(new Building(i, j));
				} else if (tmp == 2) {
					chicken.add(new Building(i, j));
				}
			}
		}

		// 조합
		combination(0, 0);
		System.out.println(chickenDistance);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			int sum = 0;

			for (int i = 0; i < home.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < selected.length; j++) {
					int x = Math.abs(home.get(i).x - selected[j].x);
					int y = Math.abs(home.get(i).y - selected[j].y);
					if (x + y < minDist) {
						minDist = x + y;
					}
				}
				sum += minDist;
			}

			if (chickenDistance > sum) {
				chickenDistance = sum;
			}
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			selected[cnt] = chicken.get(i);
			combination(cnt + 1, i + 1);
		}
	}
}
