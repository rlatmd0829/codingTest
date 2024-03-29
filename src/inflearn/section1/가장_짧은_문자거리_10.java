package inflearn.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장_짧은_문자거리_10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();

		String[] strs = str1.split("");

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals(str2)) {
				answer.add(i);
			}
		}

		for (int i = 0; i < strs.length; i++) {
			int minn = Integer.MAX_VALUE;
			if (strs[i].equals(str2)) {
				System.out.print(0 + " ");
			} else {
				for (int j = 0; j < answer.size(); j++) {
					minn = Math.min(minn, Math.abs(i - answer.get(j)));
				}
				System.out.print(minn + " ");
			}
		}
	}
}
