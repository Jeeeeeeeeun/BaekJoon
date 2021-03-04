package day0225;

import java.util.Scanner;

public class Main_2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int nx1 = sc.nextInt();
			int ny1 = sc.nextInt();
			int nx2 = sc.nextInt();
			int ny2 = sc.nextInt();

			if ((nx2 < x1 || x2 < nx1) && (ny2 < y1 || y2 < ny1)) {
				System.out.println("d");
			} else if ((x1 == nx2 && y1 == ny2) || (x1 == nx2 && y2 == ny1) || (x2 == nx1 && y2 == ny1)
					|| (x2 == nx1 && y1 == ny2)) {
				System.out.println("c");
			} else if ((y2 == ny1 || y1 == ny2) && ((x1 < nx1 && x2 > nx1) || (x1 < nx2 && nx2 < x2))) {
				System.out.println("b");
			} else if ((x2 == nx1 || x1 == nx2) && ((y1 < ny1 && ny1 < y2) || (y1 < ny2 && ny2 < y2))) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}

//			
//			else if (((x1 <= nx1 && nx1 <= x2) || (x1 <= nx2 && nx2 <= x2))
//					&& ((y1 <= ny1 && ny1 <= y2) || (y1 <= ny2 && ny2 <= y2))) {
//				System.out.println("a");
//			} else if (((x1 <= nx1 && nx1 <= x2) || (x1 <= nx2 && nx2 <= x2)) && (ny1 <= y1 && y2 <= ny2)) {
//				System.out.println("a");
//			} else if (((y1 <= ny1 && ny1 <= y2) || (y1 <= ny2 && ny2 <= y2)) && (nx1 <= x1 && x2 <= nx2)) {
//				System.out.println("a");
//			} else {
//				System.out.println("d");
//			}

		}
	}
}
