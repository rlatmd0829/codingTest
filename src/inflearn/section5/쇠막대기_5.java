package inflearn.section5;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기_5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String string = in.next();
		int answer = 0;

		String[] strs = string.split("");
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("(")) {
				stack.push(strs[i]);
			} else {
				stack.pop();
				if (strs[i - 1].equals("(")) {
					// 레이저
					answer += stack.size();
				} else {
					// 쇠막대기 끝
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
