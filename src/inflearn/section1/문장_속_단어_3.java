package inflearn.section1;

import java.util.Scanner;

public class 문장_속_단어_3 {
	public static void main(String[] args){
		String answer = "";
		Scanner in=new Scanner(System.in);
		String input = in.nextLine();

		String[] split = input.split(" ");

		for (String s : split) {
			if (answer.length() < s.length()) {
				answer = s;
			}
		}
		System.out.println(answer);
	}
}
