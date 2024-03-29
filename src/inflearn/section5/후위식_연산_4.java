package inflearn.section5;

import java.util.Scanner;
import java.util.Stack;

public class 후위식_연산_4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String input1 = in.nextLine();

		char[] chars = input1.toCharArray();
		Stack<Integer> stack = new Stack<>();

		for (char aChar : chars) {
			if (Character.isDigit(aChar)) {
				stack.push(aChar - '0');
			} else {
				int rt = stack.pop();
				int lt = stack.pop();
				if (aChar == '+') {
					stack.push(lt + rt);
				} else if (aChar == '-') {
					stack.push(lt - rt);
				} else if (aChar == '*') {
					stack.push(lt * rt);
				} else {
					stack.push(lt / rt);
				}
			}
		}
		System.out.println(stack.pop());
	}
}
