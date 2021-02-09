package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_15649_N과M1 {
	static int[] numbers;
	static int N;
	static int R;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
	}
	
	static void permutation(int cnt) {
		if (cnt == R) {
			for(int i=0; i<numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println("");
			
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
