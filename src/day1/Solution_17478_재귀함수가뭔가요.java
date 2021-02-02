package day1;
import java.util.Scanner;

public class Solution_17478_재귀함수가뭔가요 {

	static String s0 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
	static String s1 = "\"재귀함수가 뭔가요?\"";
	static String s2_1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String s2_2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String s2_3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String s3 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String s4 = "라고 답변하였지.";

	static String underbar = "";

	private static void recursive(int i) {

		String innerUnderbar = underbar;

		if (i == 0) {
			System.out.println(innerUnderbar + s1);
			System.out.println(innerUnderbar + s3);
			System.out.println(innerUnderbar + s4);
			return;
		}

		System.out.println(innerUnderbar + s1);
		System.out.println(innerUnderbar + s2_1);
		System.out.println(innerUnderbar + s2_2);
		System.out.println(innerUnderbar + s2_3);
		underbar += "____";
		recursive(i - 1);
		System.out.println(innerUnderbar + s4);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(s0);
		recursive(n);
	}
}
