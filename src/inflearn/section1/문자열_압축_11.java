package inflearn.section1;

import java.util.Scanner;

public class 문자열_압축_11 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str = in.next();

		String[] strs = str.split("");
		String answer = strs[0];
		String temp = strs[0];
		int cnt = 1;
		for (int i = 1; i < strs.length; i++) {
			if (temp.equals(strs[i])) {
				cnt++;
			} else {
				if (cnt == 1) {
					answer += strs[i];
					// temp = strs[i];
				} else {
					answer += cnt;
					answer += strs[i];
					// temp = strs[i];
					cnt = 1;
				}
			}
			temp = strs[i];
		}
		if (cnt > 1) {
			answer += cnt;
		}
		System.out.println(answer);
	}
}
