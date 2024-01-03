package inflearn.section1;

import java.util.Scanner;

public class 숫자만_추출_9 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str = in.nextLine();
		StringBuilder a = new StringBuilder();

		char[] chars = str.toCharArray();
		for (char aChar : chars) {
			if (Character.isDigit(aChar)) {
				a.append(aChar);
			}
		}
		System.out.println(Integer.parseInt(a.toString()));
	}
}
