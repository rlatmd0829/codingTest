package N_2024.july;

import java.util.Scanner;

public class 문장_속_단어 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s = in.nextLine();
		String[] strs = s.split(" ");

		int maxx = 0;
		String answer = "";
		for (String str : strs) {
			if (str.length() > maxx) {
				maxx = str.length();
				answer = str;
			}
		}
		System.out.println(answer);
	}
}
