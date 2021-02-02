package day1;

import java.util.Scanner;

public class Solution_6603_로또 {
	static int recursive(int n1, int n2) {
		if (n1==n2 || n2==0) {
			return 1;
		}
		
		
	}
	
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("7 1 2 3 4 5 6 7\r\n" + 
				"8 1 2 3 5 8 13 21 34\r\n" + 
				"0");
		
		while(true) {
			if (sc.nextInt()==0) break;
			
			int testCnt = sc.nextInt();
			int[] testList = new int[testCnt];
			
			for(int i=0; i<testCnt; i++) {
				testList[i] = sc.nextInt();
			}
			
			
			
		}
	}
}
