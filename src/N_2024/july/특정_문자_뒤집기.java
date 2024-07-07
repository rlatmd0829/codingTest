package N_2024.july;

import java.util.Scanner;

public class 특정_문자_뒤집기 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s = in.next();
		char[] chars = s.toCharArray();
		int lt = 0;
		int rt = s.length()-1;
		while (lt < rt) {
			if (!Character.isAlphabetic(chars[lt])) {
				lt++;
			} else if (!Character.isAlphabetic(chars[rt])) {
				rt--;
			} else {
				char temp = chars[lt];
				chars[lt] = chars[rt];
				chars[rt] = temp;
				lt++;
				rt--;
			}
		}
		System.out.println(String.valueOf(chars));
	}
}
