package N_2023.december;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int answer = 0;
		Scanner in=new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.next();

		char[] chars = input1.toCharArray();

		for (char aChar : chars) {
			if (String.valueOf(aChar).equalsIgnoreCase(input2)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
