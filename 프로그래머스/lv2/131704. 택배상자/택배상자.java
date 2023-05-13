import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
		Stack<Integer> originStack = new Stack<>();
		for (int i = order.length; i > 0; i--) {
			originStack.push(i);
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < order[0]; i++) {
			stack.push(i);
			originStack.pop();
		}

		int i = 0;
		while (true) {
			if (!originStack.isEmpty() && order[i] == originStack.peek()) {
				originStack.pop();
				answer++;
				i++;
			} else if (!stack.isEmpty() && order[i] == stack.peek()) {
				stack.pop();
				answer++;
				i++;
			} else if (!originStack.isEmpty() && order[i] > originStack.peek()) {
				stack.push(originStack.peek());
				originStack.pop();
			} else {
				break;
			}
		}
		return answer;
    }
}