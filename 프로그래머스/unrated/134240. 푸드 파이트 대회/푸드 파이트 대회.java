import java.util.*;
class Solution {
    public String solution(int[] food) {
                String answer = "";
        Queue<Integer> queue = new LinkedList();
        Stack<Integer> stack = new Stack();
        for (int i = 1; i < food.length; i++) {
            int number = food[i] / 2;
            if (number == 0) {
                continue;
            }
            for (int j = 0; j < number; j++) {
                queue.add(i);
                stack.add(i);
            }

        }
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            answer += queue.poll();
        }
        answer += "0";
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            int abc = stack.pop();
            answer += abc;
        }

        return answer;
    }
}