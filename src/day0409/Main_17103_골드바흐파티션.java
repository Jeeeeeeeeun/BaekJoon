package day0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17103_골드바흐파티션 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] primes = new boolean[1000001]; // false인게 prime

		for (int i = 2; i < primes.length; i++) {
			if (primes[i])
				continue;

			for (int j = i * 2; j < primes.length; j += i) {
				primes[j] = true;
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int pCnt = 0;

			for (int i = 2; i <= n / 2; i++) {
				int p1 = i;
				int p2 = n - i;

				if (!primes[p1] && !primes[p2]) {
					pCnt++;
				}
			}
			System.out.println(pCnt);
		}

	}
}
