package N_2024.february;

import java.util.Stack;

public class 괄호_회전하기 {
	public static void main(String[] args) {
		String s = "";
		int result = solution(s);
		System.out.println(result);
	}

	public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			Stack<String> stack = new Stack<>();
			s = s.substring(1) + s.charAt(0);

			String[] str = s.split("");
			int cnt = 0;
			for (int j = 0; j < str.length; j++) {
				if (str[j].equals("(") || str[j].equals("{") || str[j].equals("[")) {
					stack.push(str[j]);
				} else {
					if (stack.isEmpty()) {
						break;
					}
					while (!stack.isEmpty()) {
						String p = stack.pop();
						if (str[j].equals(")") && p.equals("(")) {
							cnt++;
							break;
						}
						if (str[j].equals("}") && p.equals("{")) {
							cnt++;
							break;
						}
						if (str[j].equals("]") && p.equals("[")) {
							cnt++;
							break;
						}
					}

				}
			}
			if (s.length() % 2 == 0 && cnt == s.length()/2 && stack.isEmpty()) {
				answer++;
			}
		}

		return answer;
	}
}
