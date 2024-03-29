package inflearn.section5;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String input1 = in.next();
		Stack<String> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();

		String[] str = input1.split("");

		for (String s : str) {
			if (s.equals("(")) {
				stack.add(s);
			} else if (s.equals(")")) {
				while (true) {
					String a = stack.pop();
					if (a.equals("(")) {
						break;
					}
				}
			} else if (stack.size() != 0) {
				stack.push(s);
			} else {
				answer.append(s);
			}
		}

		System.out.println(answer);

	}
}
