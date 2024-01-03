package inflearn.section1;

import java.util.Scanner;

public class 단어_뒤집기_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int input1 = in.nextInt();
		for (int i = 0; i < input1; i++) {
			StringBuilder answer = new StringBuilder();
			String str = in.next();
			String[] strs = str.split("");
			for (int j = strs.length-1; j >= 0; j--) {
				answer.append(strs[j]);
			}
			System.out.println(answer);
		}
	}
}
