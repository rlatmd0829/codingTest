package inflearn.section1;

import java.util.Scanner;

public class 암호_12 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input = in.nextInt();
		String str = in.next();
		String answer = "";

		// # -> 1
		// * -> 0

		String[] strs = str.split("");
		String temp = "";
		for (int i = 0; i < strs.length; i++) {
			if (i != 0 && i % 7 == 0) {
				answer += (char)Integer.parseInt(temp, 2);
				temp = "";
			}
			if (strs[i].equals("#")) {
				temp += "1";
			} else {
				temp += "0";
			}
		}
		answer += (char)Integer.parseInt(temp, 2);
		System.out.println(answer);
	}
}
