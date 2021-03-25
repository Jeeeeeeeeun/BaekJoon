package day0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12738_가장긴증가하는부분수열3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int LIS[] = new int[N];

		int size = 0;
		for (int i = 0; i < N; i++) {
			int n = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if (n >= 0)
				continue;
			n = Math.abs(n) - 1;
			LIS[n] = arr[i];

			if (n == size)
				size++;
		}

		System.out.println(size);
	}
}
