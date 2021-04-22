package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2858_기숙사바닥 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int red = Integer.parseInt(st.nextToken());
		int brown = Integer.parseInt(st.nextToken());

		int L = -1;
		int W = -1;

		for (int i = 3; i < red; i++) {
			if ((red + brown) % i != 0)
				continue;

			int tmp = (red + brown) / i;

			if ((red + brown) - (2 * i) - (tmp - 2) * 2 == brown) {
				L = tmp > i ? tmp : i;
				W = tmp > i ? i : tmp;
				break;
			}
		}

		System.out.println(L + " " + W);

	}
}
