import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        ArrayList<Integer> numberList = new ArrayList();
        for (int i = 1; i <= number; i++) {
            numberList.add(divisor(i, limit, power));
            answer += numberList.get(i-1);
        }
        return answer;
    }
    
    public int divisor(int count, int limit, int power) {
        int number = 0;
        for (int i = 1; i * i <= count; i++) {
            if (i * i == count) {
                number++;
            } else if (count % i == 0) {
                number += 2;
            }
            if (number > limit) {
                return power;
            }
        }
        return number;
    }
}