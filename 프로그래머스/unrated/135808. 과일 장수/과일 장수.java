import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int ap = score.length - 1;
        int number = score.length / m;
        for (int i = 0; i < number; i++) {
            int min = k;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, score[ap]);
                ap--;
            }
            answer += min * m;
        }

        return answer;
    }
}