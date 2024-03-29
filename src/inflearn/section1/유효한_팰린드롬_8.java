package inflearn.section1;

import java.util.Scanner;

public class 유효한_팰린드롬_8 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str = in.nextLine().toLowerCase();

		char[] chars1 = str.toCharArray();
		StringBuilder ex = new StringBuilder();

		for (char c : chars1) {
			if (Character.isAlphabetic(c)) {
				ex.append(c);
			}
		}

		if (ex.toString().contentEquals(ex.reverse())) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
