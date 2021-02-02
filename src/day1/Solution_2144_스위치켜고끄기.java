package day1;

import java.util.Scanner;

public class Solution_2144_스위치켜고끄기 {
	static int[] switchList;
	static int[] gender;
	static int[] switchNum;

	static void boy(int num) {
		int index = 1;
		while (true) {
			if (index * num > switchList.length)
				break;

			switchList[index * num - 1] = (switchList[index * num - 1] == 1) ? 0 : 1;
			index++;

		}
	}

	static void girl(int num) {
		int left = num - 2;
		int right = num;

		switchList[num - 1] = switchList[num - 1] == 0 ? 1 : 0;
		while (left >= 0 && right < switchList.length) {
			if (switchList[left] == switchList[right]) {
				switchList[left] = switchList[left] == 0 ? 1 : 0;
				switchList[right] = switchList[right] == 0 ? 1 : 0;
				left--;
				right++;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner("8\r\n" + "0 1 0 1 0 0 0 1\r\n" + "2\r\n" + "1 3\r\n" + "2 7");

		int switchCnt = sc.nextInt();
		switchList = new int[switchCnt];

		for (int i = 0; i < switchCnt; i++) {
			switchList[i] = sc.nextInt();
		}

		int studentCnt = sc.nextInt();
		gender = new int[studentCnt];
		switchNum = new int[studentCnt];
		for (int i = 0; i < studentCnt; i++) {
			gender[i] = sc.nextInt();
			switchNum[i] = sc.nextInt();
			
		}

		for (int i = 0; i < studentCnt; i++) {
			if (gender[i] == 1)
				boy(switchNum[i]);
			else if (gender[i] == 2)
				girl(switchNum[i]);
		}

		for (int i = 0; i < switchList.length; i++) {
			System.out.print(switchList[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println("");
		}
	}
}
