package day0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int x = w - Math.abs(w - (p + t) % (2 * w));
		int y = h - Math.abs(h - (q + t) % (2 * h));

		System.out.println(x + " " + y);

//		// #1
//		int pDir, qDir;
//		
//		if (p==w) pDir = -1;
//		else pDir = 1;
//
//		if (q==h) qDir = -1;
//		else qDir = 1;
//		
//		for (int i = 0; i < t; i++) {
//			p += pDir;
//			q += qDir;
//			
//			if (p==w) pDir = -1;
//			else if(p==0) pDir = 1;
//
//			if (q==h) qDir = -1;
//			else if(q==0) qDir = 1;
//		}
//
//		System.out.println(p + " " + q);
//
//		
//		// #2
//		int x, y;
//
//		int[] tx = new int[2 * w];
//		int[] ty = new int[2 * h];
//
//		for (int i = 0; i <= w; i++) { // 0~w
//			tx[i] = i;
//		}
//		for (int i = w - 1; i < 0; i--) { // w-1~1
//			tx[i] = i;
//		}
//		for (int j = 0; j <= h; j++) {
//			ty[j] = j;
//		}
//		for (int j = h - 1; j < 0; j--) {
//			ty[j] = j;
//		}
//
//		x = tx[(p + t) % (2 * w)];
//		y = tx[(q + t) % (2 * h)];
//
//		System.out.println(x + " " + y);

	}
}
