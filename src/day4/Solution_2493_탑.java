package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2493_탑 {
	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner("5\r\n" + "6 9 5 7 4");
		int N = Integer.parseInt(br.readLine());
		int[] towers = new int[N + 1];

		String line = br.readLine();
		StringTokenizer s = new StringTokenizer(line, " ");
		
		for (int i = 1; i <= N; i++) {
			towers[i] = Integer.parseInt(s.nextToken());
		}

		Stack<Integer> st = new Stack<>();
		st.push(1); // index
		System.out.print(0 + " ");

		for (int i = 2; i <= N; i++) {
			while (true) {
				int n = st.peek();

				if (towers[i] >= towers[n]) {
					st.pop();
					if (st.isEmpty()) {
						st.push(i);
						System.out.print(0 + " ");
						break;
					}
				} else {
					System.out.print(n + " ");
					st.push(i);
					break;
				}
			}
		}

	}
}
