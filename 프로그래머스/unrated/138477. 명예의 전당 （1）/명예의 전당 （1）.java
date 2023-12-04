import java.util.*;
class Solution {
    public ArrayList solution(int k, int[] score) {
        ArrayList answer = new ArrayList();
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            result.add(score[i]);
            if (result.size() > k) {
                result.remove();
            }
            answer.add(result.peek());
        }
        return answer;
    }
}