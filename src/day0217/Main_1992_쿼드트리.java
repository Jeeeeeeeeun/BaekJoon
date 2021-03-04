package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	static int[][] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = s.charAt(j) - '0';
			}
		}

		String answer = divide(N, 0, 0);
		System.out.println(answer);
	}

	private static String divide(int n, int r, int c) { // 한변길이, row, col
		if (n == 1) {
			return Integer.toString(data[r][c]);
		}

		String lu = divide(n / 2, r, c);
		String ru = divide(n / 2, r, c + n / 2);
		String ld = divide(n / 2, r + n / 2, c);
		String rd = divide(n / 2, r + n / 2, c + n / 2);

		if (lu.length() == 1 && lu.equals(ru) && lu.equals(ld) && lu.equals(rd)) { // 4개 다 같으면
			return lu;
		} else {
			return "(" + lu + ru + ld + rd + ")";
		}

	}

}
