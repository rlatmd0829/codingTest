package N_2023.inflearn.section1;

import java.util.Scanner;

public class 특정_문자_뒤집기_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String input = in.nextLine();
		StringBuilder answer = new StringBuilder();
		char[] strs = input.toCharArray();
		int point = strs.length-1;

		loop:
		for (int i = 0; i < strs.length; i++) {
			if (i > point) {
				break;
			}
			if (Character.isAlphabetic(strs[i])) {
				while (true) {
					if (point == i) {
						break loop;
					}
					if (Character.isAlphabetic(strs[point])) {
						char temp = strs[i];
						strs[i] = strs[point];
						strs[point] = temp;
						point--;
						break;
					}
					point--;
				}
			}
		}

		for (char str : strs) {
			answer.append(str);
		}

		System.out.println(answer);
	}
}
