package N_2023.inflearn.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 중복_문자_제거_6 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] strs = str.split("");
		StringBuilder answer = new StringBuilder();
		List<String> list = new ArrayList<>();

		for (String s : strs) {
			if (!list.contains(s)) {
				list.add(s);
				answer.append(s);
			}
		}

		System.out.println(answer);
	}
}
