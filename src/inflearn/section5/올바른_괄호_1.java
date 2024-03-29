package inflearn.section5;

import java.util.Scanner;
import java.util.Stack;

public class 올바른_괄호_1 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String input1 = in.nextLine();

		char[] chars = input1.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char aChar : chars) {
			if (aChar == '(') {
				stack.push(aChar);
			} else {
				if (stack.isEmpty()) {
					System.out.println("NO");
					return;
				} else {
					stack.pop();
				}
			}
		}

		if (stack.size() != 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}
