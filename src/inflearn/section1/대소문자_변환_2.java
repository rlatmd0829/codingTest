package inflearn.section1;

import java.util.Scanner;

public class 대소문자_변환_2 {
	public static void main(String[] args){
		StringBuilder answer = new StringBuilder();
		Scanner in=new Scanner(System.in);
		String input = in.nextLine();
		char[] chars = input.toCharArray();
		for (char aChar : chars) {
			if (Character.isUpperCase(aChar)) {
				answer.append(String.valueOf(aChar).toLowerCase());
			} else {
				answer.append(String.valueOf(aChar).toUpperCase());
			}
		}
		System.out.println(answer);
	}
}
