package inflearn.section5;

import java.util.Scanner;

public class 교육과정_설계_7 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str1 = in.next();
		String str2 = in.next();

		String[] str1s = str1.split("");
		String[] str2s = str2.split("");

		for (String s : str2s) {
			if (str1.contains(s)) {
				if (str1.indexOf(s) == 0) {
					str1 = str1.substring(1);
				} else {
					System.out.println("NO");
					return;
				}
			}
		}
		if (str1.length() == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
